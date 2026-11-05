#include <bits/stdc++.h>

using namespace std;

void shellSort(vector<int> arr){
    int n = arr.size();
    for(int gap = n / 2; gap > 0; gap /= 2){
        for(int i = gap; i < n ; i ++){
            int temp = arr[i];
            int j = i;
            while(j >= gap && arr[j - gap] >= arr[j]){
                arr[j] = arr[j - gap];
                j -= gap;
            }
            arr[j] = temp;
        }
    }
}

void merge(vector<int>& arr, int left, int mid, int right){

    int n1 = mid - left + 1;
    int n2 = right - mid; 

    int L[n1], R[n2];
    for(int i = 0; i < n1; i ++) L[i] = arr[left + i];
    for(int i = 0; i < n2; i ++) R[i] = arr[mid + i + 1];

    int i = 0;
    int j = 0;
    int idx = left;
    
 
    while(i < n1 && j < n2){
        if(L[i] < R[j]){
            arr[idx] = L[i];
            i ++;
        }
        else{
            arr[idx] = R[j];
            j ++;
        }
        idx ++;
    }

    while(i < n1){
        arr[idx] = L[i];
        i ++;
        idx ++;
    }
    
    while(j < n2){
        arr[idx] = R[j];
        j ++;
        idx ++;
    }
}

void mergeSort(vector<int>& arr, int left, int right){
    if(left >= right) return;

    int mid = (left + right) / 2;

    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);
    merge(arr, left, mid, right);
}

int main() {
    vector<int> arr = {170, 45, 75, 90, 802, 24, 2, 66};
    mergeSort(arr, 0, arr.size() - 1);
    for(int i = 0; i < arr.size(); i ++) cout << arr[i] << " ";
    return 0;
}