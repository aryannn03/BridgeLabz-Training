public class MatrixAdvanced{
    public static double[][] createMatrix(int r,int c){
        double[][] m=new double[r][c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                m[i][j]=(int)(Math.random()*5)+1;
        return m;
    }
    public static double[][] transpose(double[][] m){
        double[][] t=new double[m[0].length][m.length];
        for(int i=0;i<m.length;i++)
            for(int j=0;j<m[0].length;j++)
                t[j][i]=m[i][j];
        return t;
    }
    public static double determinant2x2(double[][] m){
        return m[0][0]*m[1][1]-m[0][1]*m[1][0];
    }
    public static double determinant3x3(double[][] m){
        return m[0][0]*(m[1][1]*m[2][2]-m[1][2]*m[2][1])- m[0][1]*(m[1][0]*m[2][2]-m[1][2]*m[2][0])+ m[0][2]*(m[1][0]*m[2][1]-m[1][1]*m[2][0]);
    }
    public static double[][] inverse2x2(double[][] m){
        double det=determinant2x2(m);
        double[][] inv=new double[2][2];
        inv[0][0]= m[1][1]/det;
        inv[0][1]=-m[0][1]/det;
        inv[1][0]=-m[1][0]/det;
        inv[1][1]= m[0][0]/det;
        return inv;
    }

    public static double[][] inverse3x3(double[][] m){
        double det=determinant3x3(m);
        double[][] inv=new double[3][3];

        inv[0][0]=(m[1][1]*m[2][2]-m[1][2]*m[2][1])/det;
        inv[0][1]=(m[0][2]*m[2][1]-m[0][1]*m[2][2])/det;
        inv[0][2]=(m[0][1]*m[1][2]-m[0][2]*m[1][1])/det;

        inv[1][0]=(m[1][2]*m[2][0]-m[1][0]*m[2][2])/det;
        inv[1][1]=(m[0][0]*m[2][2]-m[0][2]*m[2][0])/det;
        inv[1][2]=(m[0][2]*m[1][0]-m[0][0]*m[1][2])/det;

        inv[2][0]=(m[1][0]*m[2][1]-m[1][1]*m[2][0])/det;
        inv[2][1]=(m[0][1]*m[2][0]-m[0][0]*m[2][1])/det;
        inv[2][2]=(m[0][0]*m[1][1]-m[0][1]*m[1][0])/det;

        return inv;
    }

    public static void display(double[][] m){
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++)
                System.out.print(m[i][j]+" ");
            System.out.println();
        }
    }

    public static void main(String[] args){
        double[][] m3=createMatrix(3,3);
        double[][] m2=createMatrix(2,2);

        display(m3);
        System.out.println();
        display(transpose(m3));
        System.out.println();
        System.out.println(determinant3x3(m3));
        System.out.println();
        display(inverse3x3(m3));
        System.out.println();
        display(m2);
        System.out.println();
        System.out.println(determinant2x2(m2));
        System.out.println();
        display(inverse2x2(m2));
    }
}
