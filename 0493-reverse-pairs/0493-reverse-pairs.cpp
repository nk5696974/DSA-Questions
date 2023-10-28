void merge(std::vector<int> &arr, int low, int mid, int high) {
    std::vector<int> temp; // temporary array
    int left = low;      // starting index of the left half of arr
    int right = mid + 1;   // starting index of the right half of arr

    // Storing elements in the temporary array in a sorted manner
    while (left <= mid && right <= high) {
        if (arr[left] <= arr[right]) {
            temp.push_back(arr[left]);
            left++;
        } else {
            temp.push_back(arr[right]);
            right++;
        }
    }

    // If elements in the left half are still left
    while (left <= mid) {
        temp.push_back(arr[left]);
        left++;
    }

    // If elements in the right half are still left
    while (right <= high) {
        temp.push_back(arr[right]);
        right++;
    }

    // Transferring all elements from temporary to arr
    for (int i = low; i <= high; i++) {
        arr[i] = temp[i - low];
    }
}

long long countPairs(std::vector<int> &arr, int low, int mid, int high) {
    int right = mid + 1;
    long long cnt = 0;
    for (int i = low; i <= mid; i++) {
        while (right <= high && static_cast<long long>(arr[i]) > 2 * static_cast<long long>(arr[right])) {
            right++;
        }
        cnt += (right - (mid + 1));
    }
    return cnt;
}

long long mergeSort(std::vector<int> &arr, int low, int high) {
    long long cnt = 0;
    if (low >= high) return cnt;
    int mid = low + (high - low) / 2; // Calculate the middle index correctly
    cnt += mergeSort(arr, low, mid);  // left half
    cnt += mergeSort(arr, mid + 1, high); // right half
    cnt += countPairs(arr, low, mid, high);
    merge(arr, low, mid, high);
    return cnt;
}

class Solution {
public:
    int reversePairs(std::vector<int>& nums) {
        return static_cast<int>(mergeSort(nums, 0, nums.size()-1));
    }
};
