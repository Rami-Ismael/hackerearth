   static MyScanner in = new MyScanner();
    static   PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    int N;
    static int [][] BIT;
    static int max = 200001;
    public static void main(String args[]) throws IOException {
      int n = in.nextInt();
      Integer [] arr =  new Integer[n];
      for(int i=0;i<n;i++){
          arr[i] =  Integer.valueOf(in.next());
      }
      Arrays.sort(arr);
        int Q = in.nextInt();
        while(Q-->0){
            int M = in.nextInt();
            //lowerbound
            int lo =0;
            int hi = n-1;
            int mid = (lo+hi)>>>1;
            while(lo<hi){
                mid = (lo+hi)>>>1;
                if(M>arr[mid]){
                    lo = mid+1;
                }else{
                    hi = mid;
                }
            }
            if(arr[lo]<M){
                pw.println(lo+1);
            }else{
            pw.println(lo);
            }
        }
        pw.flush();
        }
        


    
  
