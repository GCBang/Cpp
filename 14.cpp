#include <stdio.h>
int reverse(int x){
    int res=0, tmp;
    while(x>0){
        tmp=x%10;
        res=res*10+tmp;
        x=x/10;
    }
    return res;
}
bool isPrime(int x){
    int i;

    for(i=2; i<x; i++){
        if(x%i == 0)
            return false;
    }
    return true;
}

int main(){
	freopen("14input.txt", "rt", stdin);
	int n, num, i, tmp;
    scanf("%d", &n);
    for(i=1; i<=n; i++){
        scanf("%d", &num);
        tmp=reverse(num);
        if(isPrime(tmp)) printf("%d ", tmp);
    }
}