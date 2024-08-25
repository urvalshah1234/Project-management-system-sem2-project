import java.util.Scanner;

class project_management_system
{
    public static void main(String[] args) throws Exception {
        list l=new list();
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME TO PROJECT MANAGEMENT SYSTEM");
        System.out.println();
        // faculty work is there to enter the details of studnent to system.
            System.out.println("LOADING");
            for (int i = 1; i < 25; i++) 
            {
                Thread.sleep(100);
                System.out.print(".");    
            } 
            System.out.println();
            System.out.println();
            
            System.out.println("ENTER NUM OF STUDENTS ");
            int x=sc.nextInt();
            System.out.println();
            System.out.println("ENTER DETAILS OF STUDNETS");
            for(int i=1;i<=x;i++)
            {
                System.out.println("-----------------------------------");
                System.out.println("Enter roll no of student "+i);
                System.out.println("Make sure while entering roll no it wont repeat again.");
                int id=sc.nextInt();
                sc.nextLine();
                System.out.println("Enter name of student "+i);
                String name=sc.nextLine();
                System.out.println("Enter enroll of student "+i);
                long enroll=sc.nextLong();
                sc.nextLine();
                System.out.println("Enter div of student "+i);
                String div=sc.nextLine();
                System.out.println("Enter branch of student "+i);
                String branch=sc.nextLine();
                System.out.println("Enter DS PROJECT TITLE of student "+i);
                String dsproject=sc.nextLine();
                System.out.println("Enter JAVA PROJECT TITLE of student "+i);
                String javaproject=sc.nextLine();
                System.out.println("Enter DBMS PROJECT TITLE of student "+i);
                String dbmsproject=sc.nextLine();
                System.out.println("Enter FEE PROJECT TITLE of student "+i);
                String feeproject=sc.nextLine();
                System.out.println("-----------------------------------");
                l.sorted(id, name, enroll, div, branch, dsproject, javaproject, dbmsproject, feeproject);
            }
           // l.bubblesort();
            System.out.println();
        l.deleteduplicates();
        System.out.println("FULL DETAILS OF ALL STUDENTS WITH THEIR PROJECTS TITLES");
        System.out.println();
        l.display();
        l.count();
        System.out.println();
        System.out.println("PROJECT CO-CORDINATOR");
        System.out.println();
        int num=0;
            boolean check=true;
        do
        {
            System.out.println("ENTER ROLL.NO OF STUDENT TO GIVE MARKS");
            int student_rollno=sc.nextInt();
            int result=l.particular(student_rollno);
            if(result==1)
            {
            num++;

            }
            if(num==x)
            {
                check=false;
            }    
        }
        while(check);  






        l.displaymarks();
        l.displayrank2();
        System.out.println();
    }
}
class list
{
    Scanner sc=new Scanner(System.in);
    class node
    {
        node next;
        int id;
        String name;
        long enroll;
        String div;
        String branch;
        String dsproject;
        String javaproject;
        String dbmsproject;
        String feeproject;
        public node(int id, String name, long enroll, String div, String branch, String dsproject, String javaproject,
                String dbmsproject, String feeproject) {
            this.id = id;
            this.name = name;
            this.enroll = enroll;
            this.div = div;
            this.branch = branch;
            this.dsproject = dsproject;
            this.javaproject = javaproject;
            this.dbmsproject = dbmsproject;
            this.feeproject = feeproject;
        }
        void show()
        {
            System.out.println("-----------------------------------");
            System.out.println("ROLL no = "+id);
            System.out.println("NAME = "+name);
            System.out.println("ENROLL num = "+enroll);
            System.out.println("DIVISION = "+div);
            System.out.println("BRANCH = "+branch);
            System.out.println("DS PROJECT NAME = "+dsproject);
            System.out.println("JAVA PROJECT NAME = "+javaproject);
            System.out.println("DBMS PROJECT NAME = "+dbmsproject);
            System.out.println("FEE PROJECT NAME = "+feeproject);
            System.out.println("-----------------------------------\n");
        }
    
    }
    list2 l1=new list2();
    node first=null;
    void addfirst(int id, String name, long enroll, String div, String branch, String dsproject, String javaproject,
                String dbmsproject, String feeproject)
    {
        node n=new node(id,name,enroll,div,branch,dsproject,javaproject,
            dbmsproject,feeproject);
        if(first==null)
        {
            first=n;
        }
        else
        {
            n.next=first;
            first=n;
        }
    }
    //
    void sorted(int id, String name, long enroll, String div, String branch, String dsproject, String javaproject,
                String dbmsproject, String feeproject)
    {
        node n=new node(id,name, enroll,div,branch,dsproject,javaproject,
            dbmsproject,feeproject);
        if(first==null || first.id>=id)
        {
            addfirst(id,name, enroll,div,branch,dsproject,javaproject,
            dbmsproject,feeproject);
        }
        else
        {
            node temp=first;
            while(temp.next!=null && temp.next.id<id)
            {
                temp=temp.next;
            }
            n.next=temp.next;
            temp.next=n;
        }
    }
    //

    void bubblesort()
    {    
        boolean check;
        do{
            check=false;
            node temp=first;
            while (temp.next!=null) 
            {
                if(temp.id>temp.next.id)
                {
                    int swap=temp.id;
                    temp.id=temp.next.id;
                    temp.next.id=swap;
                    check=true;
                }
                temp=temp.next;
            }
            
        }while (check);
    }
    void deleteduplicates()
    {
        if (first==null)
        {
            System.out.println("EMPTY CLASS");
        }
        else
        {
            node temp=first;
            while (temp!=null) 
            {
                node run=temp;
                while (run.next!=null) 
                {
                    if(run.next.id==temp.id)
                    {
                        run.next=run.next.next;
                    }
                    else
                    {
                        run=run.next;
                    }
                }    
                temp=temp.next;
            }
        }
    }
    void display()
    {
        if(first==null)
        {
            System.out.println("NO STUDENTS IN CLASS");
        }
        else
        {
            node temp=first;
            System.out.println("STUDENT DETAILS");
            System.out.println();
            while (temp!=null) 
            {     
                temp.show();               
                temp=temp.next;    
            }
        }
    }
    void count()
    {
        int count=0;
        node temp=first;
            
            while (temp!=null) 
            {     
                count++;               
                temp=temp.next;    
            }
        System.out.println("------------------------------");
        System.out.println("THERE ARE TOTAL "+count+" STUDENTS ");
        System.out.println("------------------------------");
    }
    public int  particular(int value)
    {
        node dummy=first;
        int flag=0;
        do 
        {
            if(dummy.id==value)
            {
                flag=1;
                break;
            }    
            dummy=dummy.next;
        }while (dummy!=null);
        if(flag==0)
        {
            System.out.println("ROLL NO DOES NOT EXIST");
            return 0;
        }
        else
        {
            System.out.println("DETAILS OF STUDENT ROLL NO "+value);
            dummy.show();
            System.out.println("GIVE MARKS FOR DS PROJECT FOR ROLL NO "+value);
            int ds_marks=sc.nextInt();
            System.out.println("GIVE MARKS FOR JAVA PROJECT FOR ROLL NO "+value);
            int java_marks=sc.nextInt();
            System.out.println("GIVE MARKS FOR DBMS PROJECT FOR ROLL NO "+value);
            int dbms_marks=sc.nextInt();
            System.out.println("GIVE MARKS FOR FEE PROJECT FOR ROLL NO "+value);
            int fee_marks=sc.nextInt();
            System.out.println();
            int total_marks=ds_marks+fee_marks+dbms_marks+java_marks;
            l1.sorted2(value,dummy.name,dummy.enroll,dummy.div,dummy.branch,dummy.dsproject,dummy.javaproject,dummy.dbmsproject,dummy.feeproject,ds_marks,java_marks,dbms_marks,fee_marks,total_marks);
        return 1;
        }
    }
    void displaymarks()
    {
        l1.deleteduplicates2();
        l1.display();
    }
    void displayrank2()throws Exception
    {
        l1.displayrank();
    }
}
class list2
{
    class node
    {
        node next;
        int id;
        String name;
        long enroll;
        String div;
        String branch;
        String dsproject;
        String javaproject;
        String dbmsproject;
        String feeproject;
        int dsmarks;
        int javamarks;
        int dbmsmarks;
        int feemarks;
        int total_marks;
        public node(int id, String name, long enroll, String div, String branch, String dsproject, String javaproject,
                String dbmsproject, String feeproject, int dsmarks, int javamarks, int dbmsmarks, int feemarks,int total_marks) {
            this.id = id;
            this.name = name;
            this.enroll = enroll;
            this.div = div;
            this.branch = branch;
            this.dsproject = dsproject;
            this.javaproject = javaproject;
            this.dbmsproject = dbmsproject;
            this.feeproject = feeproject;
            this.dsmarks = dsmarks;
            this.javamarks = javamarks;
            this.dbmsmarks = dbmsmarks;
            this.feemarks = feemarks;
            this.total_marks=total_marks;
        }  
        void show()
        {
            
            System.out.println("ROLL no = "+id);
            System.out.println("NAME = "+name);
            System.out.println("ENROLL num = "+enroll);
            System.out.println("DIVISION = "+div);
            System.out.println("BRANCH = "+branch);
            System.out.println("DS PROJECT NAME = "+dsproject+" AND MARKS = "+dsmarks);
            System.out.println("JAVA PROJECT NAME = "+javaproject+" AND MARKS = "+javamarks);
            System.out.println("DBMS PROJECT NAME = "+dbmsproject+" AND MARKS = "+dbmsmarks);
            System.out.println("FEE PROJECT NAME = "+feeproject+" AND MARKS = "+feemarks);
            System.out.println("TOTAL MARKS FROM 400 IS "+total_marks);
            System.out.println("-----------------------------------\n");
        }
    }   
    node first=null;
    void addfirst(int id, String name, long enroll, String div, String branch, String dsproject, String javaproject,
                String dbmsproject, String feeproject,int dsmarks,int javamarks,int dbmsmarks,int feemarks,int total_marks)
    {
        node n=new node(id,name,enroll,div,branch,dsproject,javaproject,
            dbmsproject,feeproject,dsmarks,javamarks,dbmsmarks,feemarks,total_marks);
        if(first==null)
        {
            first=n;
        }
        else
        {
            n.next=first;
            first=n;
        }
    }
    void sorted2(int id, String name, long enroll, String div, String branch, String dsproject, String javaproject,
                String dbmsproject, String feeproject, int dsmarks, int javamarks, int dbmsmarks, int feemarks,int total_marks)
    {
        node n=new node(id,name, enroll,div,branch,dsproject,javaproject,
            dbmsproject,feeproject, dsmarks, javamarks, dbmsmarks,feemarks,total_marks);
        if(first==null || first.total_marks<=total_marks)
        {
            addfirst(id,name, enroll,div,branch,dsproject,javaproject,
            dbmsproject,feeproject, dsmarks, javamarks, dbmsmarks,feemarks,total_marks);
        }
        else
        {
            node temp=first;
            while(temp.next!=null && temp.next.total_marks>total_marks)
            {
                temp=temp.next;
            }
            n.next=temp.next;
            temp.next=n;
        }
    }
    void deleteduplicates2()
    {
        if (first==null)
        {
            System.out.println("EMPTY CLASS");
        }
        else
        {
            node temp=first;
            while (temp!=null) 
            {
                node run=temp;
                while (run.next!=null) 
                {
                    if(run.next.id==temp.id)
                    {
                        run.next=run.next.next;
                    }
                    else
                    {
                        run=run.next;
                    }
                }    
                temp=temp.next;
            }
        }
    }
    void display()
    {
        if(first==null)
        {
            System.out.println("RANK LIST IS EMPTY");
        }
        else
        {
            node temp=first;
            int rank=0;
            System.out.println("-----------------------------------");
            System.out.println("STUDENT DETAILS WITH TOTAL MARKS AND RANK");
            System.out.println();
            System.out.println("-------------MARKSHEET-------------");
            

            while (temp!=null) 
            {     
                rank++;
                System.out.println("-----------------------------------");
                System.out.println("RANK "+rank);
                r.addlast(temp.id);
                temp.show();               
                temp=temp.next;    
            }
        }       
    }  
    rank r=new rank();
    void displayrank() throws Exception
    {
        r.display();
    } 
}
class rank
{
    class node
    {
        node next;
        int data;
        node(int data)
        {
            this.data=data;
        }
    }
    node first=null;
    void addlast(int data)
    {
        node n=new node(data);
        if(first==null)
        {
            first=n;
        }
        else
        {
            node temp=first;
            while(temp.next!=null)
            {
                temp=temp.next;
            }  
            temp.next=n;
        }
    }
    void display() throws InterruptedException
    {
        node temp=first;
        int rank=0;
        System.out.println("----------RANK LIST-----------");
        System.out.println("RANK LIST ACCORDING TO TOTAL MARKS OF ALL PROJECTS CONTAINNING ROLL NO AND RANK");
        System.out.println("---------------------------");
        while(temp!=null)
        {
            rank++;
            System.out.println("| ROLL NO = "+temp.data+" HAS "+rank+" RANK. |");
            temp=temp.next;
        }
        System.out.println("---------------------------");
    }
}
