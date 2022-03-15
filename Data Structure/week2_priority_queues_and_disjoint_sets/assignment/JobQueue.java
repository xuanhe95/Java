import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class JobQueue {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

    private void assignJobs() {
        // TODO: replace this code with a faster algorithm.
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];
        long[] nextFreeTime = new long[numWorkers];
        for (int i = 0; i < jobs.length; i++) {
            int duration = jobs[i];
            int bestWorker = 0;
            for (int j = 0; j < numWorkers; ++j) {
                if (nextFreeTime[j] < nextFreeTime[bestWorker])
                    bestWorker = j;
            }
            assignedWorker[i] = bestWorker;
            startTime[i] = nextFreeTime[bestWorker];
            nextFreeTime[bestWorker] += duration;
        }
    }
    
    private void assignJobsFast(){
        HeapWithID threads = new HeapWithID(numWorkers);
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];
        
        for(int i=0;i<jobs.length;i++){
            assignedWorker[i] = threads.getPeakID();
            long time = threads.getPeak();
            startTime[i] = time;
            time += jobs[i];
            threads.replace(time);
                        
        }
    }

    public void test(){
        numWorkers = 10;
        
        String text = "124860658 388437511 753484620 349021732 311346104 235543106 665655446 28787989 "
        + "706718118 409836312 217716719 757274700 609723717 880970735 972393187 246159983 318988174 " 
        + "209495228 854708169 945600937 773832664 587887000 531713892 734781348 603087775 148283412 "
        + "195634719 968633747 697254794 304163856 554172907 197744495 261204530 641309055 773073192 "
        + "463418708 59676768 16042361 210106931 901997880 220470855 647104348 163515452 27308711 "
        + "836338869 505101921 397086591 126041010 704685424 48832532 944295743 840261083 407178084 "
        + "723373230 242749954 62738878 445028313 734727516 370425459 607137327 541789278 281002380 "
        + "548695538 651178045 638430458 981678371 648753077 417312222 446493640 201544143 293197772 "
        + "298610124 31821879 46071794 509690783 183827382 867731980 524516363 376504571 748818121 "
        + "36366377 404131214 128632009 535716196 470711551 19833703 516847878 422344417 453049973 "
        + "58419678 175133498 967886806 49897195 188342011 272087192 798530288 210486166 836411405 "
        + "909200386 561566778";
        
        String[] numbers = text.split(" ");
        int[] m = new int[numbers.length];
        for(int i=0;i<numbers.length;i++){
            m[i] = Integer.parseInt(numbers[i]);
        }
        jobs = m;
        
        assignJobsFast();
        for (int i = 0; i < jobs.length; ++i) {
            System.out.println(assignedWorker[i] + " " + startTime[i]);
        }

    }
    
    public void testSimple(){
        numWorkers = 5;
        int[] k = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        jobs = k;
        
        assignJobsFast();
        for (int i = 0; i < jobs.length; ++i) {
            System.out.println(assignedWorker[i] + " " + startTime[i]);
        }

    }
    

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobsFast();
        writeResponse();
        out.close();
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}


class HeapWithID {
    private long[] data;
    private int[] id;
    private int count;
    
    HeapWithID(long[] items){
        data = items;
        id = new int[items.length];
        for(int i = 0;i< items.length;i++){
            id[i] = i;
        }
        heapify();
    }
    
    HeapWithID(int size){
        data = new long[size];
        for(int i=0;i<size;i++){
            data[i] = 0;
        }
        id = new int[size];
        for(int i = 0;i< size;i++){
            id[i] = i;
        }
        count = 0;
    }
    
    
    
    private int leftChild(int i){
        return 2 * i + 1;
    }
    private int rightChild(int i){
        return 2 * i + 2;
    }
    private int parentOf(int i){
        return (i + 1) / 2 - 1;
    }
    
    private int siftDown(int i){
        long parent = data[i];
        int position = i;

        while(leftChild(position) < data.length){
            int left = leftChild(position);
            int min = left;
            if(rightChild(position) < data.length){
                int right = rightChild(position);
                if(data[right] == data[left]){  //当两者相等时，需要以id来判断
                    if(id[right] < id[left]){
                        min = right;
                    }
                    else{
                        min = left;
                    }
                    
                }
                else if(data[right] < data[left]){
                    min = right;
                }
            }
 
            if(data[position] >= data[min]){    //当数据相等时，仍需要siftdown
                data[position] = data[min];
                data[min] = parent;
                int temp = id[position];
                id[position] = id[min];
                id[min] = temp;
                
                position = min;
            }
            else{
                break;
            }
        }
        return position;
    }
    
    long pop(){
        long root = data[0];
        remove(0);
        return root;
    }
    
    long getPeak(){
        return data[0];
    }
    
    int getPeakID(){
        return id[0];
    }
    
    long replace(long item){
        long root = data[0];
        data[0] = item;
        siftDown(0);
        return root;
    }
    
    
    int remove(int i){
        if(i < data.length){
            int last = data.length - 1;
            long target = data[i];
            data[i] = data[last];
            data[last] = target;
            
            int temp = id[i];
            id[i] = id[last];
            id[last] = id[i];
            
            int position = siftDown(i);
            cutDown();
            return position;
        }
        else{
            return -1;
        }
    }
    
    int siftUp(int i){
        int position = i;
        while(position > 0){
            long child = data[position];
            long parent = data[parentOf(position)];
            if(parent > child){
                data[position] = parent;
                data[parentOf(position)] = child;
                int temp = id[position];
                id[position] = id[parentOf(position)];
                id[parentOf(position)] = temp;
                
                position = parentOf(position);
            }
            else{
                break;
            }
        }
        return position;
    }

    int add(int item){
        buildUp(item);
        int position = siftUp(data.length-1);
        return position;
    }
    
    void cutDown(){
        long[] newData = new long[data.length-1];
        for(int i=0;i<data.length-1;i++){
            newData[i] = data[i];
        }
        data = newData;
        
        int[] newID = new int[data.length-1];
        for(int i=0;i<data.length-1;i++){
            newID[i] = id[i];
        }
        id = newID;
    }
    
    private void buildUp(int item){
        long[] newData = new long[data.length+1];
        for(int i=0;i<data.length;i++){
            newData[i] = data[i];
        }
        newData[data.length] = item;
        data = newData;
        
        int[] newID = new int[data.length+1];
        for(int i=0;i<data.length;i++){
            newID[i] = id[i];
        }
        newID[data.length] = item; //Wrong
        id = newID;
        
    }
    
    private void heapify(){

        for(int i = parentOf(data.length-1); i >= 0;i--){
            siftDown(i);
        }
        
    }
    

    
}

