#include<stdio.h>
int main(){
	//freopen("11input.txt", "rt", stdin);
	int n, sum=0, c=1, d=9, cnt=0;
	scanf("%d", &n);
    while(sum + d< n ){
        cnt+=(c*d);
        sum+=d;
        c++;
        d*=10;
    }
    cnt+=(n-sum)*c;
	printf("%d\n", cnt);
	return 0;
}