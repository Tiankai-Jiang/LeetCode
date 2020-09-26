public class M134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = 0, gasSum = 0, costSum = 0, tank = 0;
        for(int i=0; i<gas.length; i++){
            gasSum += gas[i];
            costSum += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                res = i + 1;
                tank = 0;
            }
        }
        return gasSum < costSum ? -1 : res;
    }
}
