public class M957 {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int[] cycles = new int[64];
        for(int i=0; i<64; i++) cycles[i] = -1;
        int cycle = 0, i;
        boolean breakHalfWay = false;
        for(i=0; i<N; i++){
            int ind = 0;
            int prev = cells[0];
            cells[0] = 0;
            for(int j=1; j<7; j++){
                if(prev == cells[j+1]){
                    prev = cells[j];
                    cells[j] = 1;
                }else{
                    prev = cells[j];
                    cells[j] = 0;
                }
                ind = 2*ind+cells[j];
            }
            if(cycles[ind]==-1) cycles[ind] = i;
            else{
                cycle = i - cycles[ind];
                breakHalfWay = true;
                break;
            }
            cells[7] = 0;
        }

        if(breakHalfWay){
            int rest = (N-i)%cycle;
            if(rest == 0) rest = cycle;
            for(i=0; i<rest-1; i++){
                int prev = 0;
                for(int j=1; j<7; j++){
                    if(prev == cells[j+1]){
                        prev = cells[j];
                        cells[j] = 1;
                    }else{
                        prev = cells[j];
                        cells[j] = 0;
                    }
                }
            }
        }
        return cells;
    }
}
