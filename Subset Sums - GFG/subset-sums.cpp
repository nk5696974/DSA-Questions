//{ Driver Code Starts
#include<bits/stdc++.h> 
using namespace std; 

// } Driver Code Ends
class Solution
{
public:

    void solve(vector<int> arr, vector<int> &res, int i, int n, int sum) {
        if(i == n) {
            res.push_back(sum);
            return;
        }
        
        solve(arr, res, i+1, n, sum + arr[i]);
        solve(arr, res, i+1, n, sum);
    }
    
    vector<int> subsetSums(vector<int> arr, int N)
    {
        // Write Your Code here
        vector<int> res;
        //array, res to store, ith element, length of array, sum
        solve(arr, res, 0, N, 0);
        sort(res.begin(), res.end());
        
        return res;
    }
};

//{ Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int N;
        cin>>N;
        vector<int> arr(N);
        for(int i = 0 ; i < N ; i++){
            cin >> arr[i];
        }
        Solution ob;
        vector<int> ans = ob.subsetSums(arr,N);
        sort(ans.begin(),ans.end());
        for(auto sum : ans){
            cout<< sum<<" ";
        }
        cout<<endl;
    }
    return 0;
}
// } Driver Code Ends