class Solution {
    private void findCombination(int ind, int []arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if(ind == arr.length) {
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(arr[ind] <= target){
            ds.add(arr[ind]); //add kra value
            findCombination(ind, arr, target-arr[ind], ans, ds); //call for next
            ds.remove(ds.size()-1); //agar nhi bana to remove
        }
        findCombination(ind+1, arr, target, ans, ds); //agle index pe move krna hai aur same repeat
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}