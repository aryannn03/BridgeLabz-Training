public class MatrixOperations{
    public static int[][] createMatrix(int r,int c){
        int[][] m=new int[r][c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                m[i][j]=(int)(Math.random()*10);
        return m;
    }
    public static int[][] add(int[][] a,int[][] b){
        int[][] r=new int[a.length][a[0].length];
        for(int i=0;i<a.length;i++)
            for(int j=0;j<a[0].length;j++)
                r[i][j]=a[i][j]+b[i][j];
        return r;
    }
    public static int[][] subtract(int[][] a,int[][] b){
        int[][] r=new int[a.length][a[0].length];
        for(int i=0;i<a.length;i++)
            for(int j=0;j<a[0].length;j++)
                r[i][j]=a[i][j]-b[i][j];
        return r;
    }
    public static int[][] multiply(int[][] a,int[][] b){
        int[][] r=new int[a.length][b[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b[0].length;j++){
                for(int k=0;k<a[0].length;k++)
                    r[i][j]+=a[i][k]*b[k][j];
            }
        }
        return r;
    }
    public static void display(int[][] m){
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++)
                System.out.print(m[i][j]+" ");
            System.out.println();
        }
    }
    public static void main(String[] args){
        int[][] a=createMatrix(2,3);
        int[][] b=createMatrix(2,3);
        int[][] c=createMatrix(3,2);

        display(a);
        System.out.println();
        display(b);
        System.out.println();
        display(add(a,b));
        System.out.println();
        display(subtract(a,b));
        System.out.println();
        display(multiply(a,c));
    }
}
