import java.util.*;
public class DingDan1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] names=new String[4];//名字
		String [] canPin=new String[names.length]; //餐品
		int []times=new int[names.length];         //时间
		String []diZhi=new String[names.length];   //地址
		double[]zongJing=new double[names.length];//总金额
		int []zhuangTai=new int[names.length];    //状态
		//初始化
		names[0]="张智";
		canPin[0]="土豆鸡蛋 1份";
		times[0]=10;
		diZhi[0]="理工南院";
		zongJing[0]=21;
		zhuangTai[0]=1;
		
		names[1]="张智";
		canPin[1]="土豆鸡蛋 1份";
		times[1]=10;
		diZhi[1]="理工南院";
		zongJing[1]=21;
		zhuangTai[1]=0;
		//一组菜品
		String[] cais=new String[]{"土豆鸡蛋","红烧肉","时令蔬菜"};//菜名
		double []danJia=new double[]{15,30,10};            //单价
		int []zan=new int[3];                              //点赞数
		Scanner input=new Scanner(System.in);
		int x=-1;
		boolean y=false;
		do{
			System.out.println("欢迎使用“吃货联盟订餐系统”");
			System.out.println("*************************");
			System.out.println("1.我要订餐");
			System.out.println("2.查看餐袋");
			System.out.println("3.签收订单");
			System.out.println("4.删除订单");
			System.out.println("5.我要点赞");
			System.out.println("6.退出系统");
			System.out.println("*************************");
			System.out.print("请选择: ");
			int z=input.nextInt();
			switch(z){
			case 1:
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						y=true;
						System.out.println("****我要订餐****");
						System.out.print("请输入订餐人姓名:");
						String name=input.next();
						System.out.println("序号\t菜名\t单价\t点赞数");
						for(int j=0;j<cais.length;j++){
							//System.out.println("请输入订餐人姓名:");
							//names[i]=input.next();
							String danJias=danJia[j]+"元";
							System.out.println((j+1)+"\t"+cais[j]+"\t"+danJias+"\t"+zan[j]);
						}
						System.out.print("请选择您要点的菜品编号:");
						int bianHao=input.nextInt();
						System.out.print("请选择您需要的份数:");
						int fen=input.nextInt();
						System.out.print("请输入送餐时间（送餐时间是10点至20点间整点送餐）:");
						int time=input.nextInt();
						if(times[i]>20||times[i]<10){
							System.out.print("该时间段不送餐，请从新输入");
							times[i]=input.nextInt();
						}
						System.out.print("请输入送餐地址");
						String diZhis=input.next();
						System.out.println("订餐成功!");
						String di=cais[i]+fen+"份";//餐品
						System.out.println("您订的是:"+di);
						System.out.println("请输入送餐时间"+times[i]);
						double canFei=danJia[i]*fen;
						double songCan=canFei>50?0:6;
						double zong=canFei+songCan;
						System.out.println("餐费"+canFei+"送餐费"+songCan+"总计"+zong);
						names[i]=name;
						canPin[i]=di;
						times[i]=time;
						diZhi[i]=diZhis;
						zongJing[i]=zong;
					}
				}
				if(!y){
					System.out.println("餐袋已满");
				}
				break;
			case 2:
				System.out.println("****查看餐袋****");
				System.out.println("序号\t订餐人\t餐品信息\t\t送餐时间\t送餐地址\t\t总金额\t订单状态");
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
					String time=times[i]+"点";
					String zong=zongJing[i]+"元";
					String zhuangTa=zhuangTai[i]==0?"已预订":"已完成";
					System.out.println((i+1)+"\t"+names[i]+"\t"+canPin[i]+"\t"+"\t"+time+"\t"+diZhi[i]+"\t"+"\t"+zong+"\t"+zhuangTa);
					}
				}
				break;
			case 3:
				System.out.println("****签收订单****");
				System.out.println("请选择要签收的订单序号:");
				int xu=input.nextInt();
				for(int i=0;i<names.length;i++){
					if(names[i]!=null&&xu==i+1&&zhuangTai[i]==1){
						System.out.println("订单无法被再次签收");
						y=true;
						break;
					}else if(names[i]!=null&&xu==i+1&&zhuangTai[i]==0){
						System.out.println("订单签收成功");
						zhuangTai[i]=1;
						y=true;
						break;
					}
				}
				if(!y){
					System.out.println("该订单号不存在");
				}
				break;
			case 4:
				System.out.println("****删除订单****");
				System.out.print("请输入要删除的订单序号:");
				int xuH=input.nextInt();
				int next=-1;
				for(int i=0;i<names.length;i++){
					if(names[i]!=null&&xuH==i+1&&zhuangTai[i]==0){
						System.out.println("您选择的订单未签收,无法被删除");
						y=true;
						break;
					}else if(names[i]!=null&&xuH==i+1&&zhuangTai[i]==1){
						next=i;
						y=true;
						break;
					}
				}
			//	if(!y){
				//	System.out.println("该订单号不存在");
				//}
				if(next!=-1){
					for(int i=xuH+1;i<names.length;i++){
						names[i-1]=names[i];
						canPin[i-1]=canPin[i];
						times[i-1]=times[i];
						diZhi[i-1]=diZhi[i];
						zongJing[i-1]=zongJing[i];
						zhuangTai[i-1]=zhuangTai[i];
					}
					System.out.println("删除成功");
					names[names.length-1]=null;
					canPin[names.length-1]=null;
					times[names.length-1]=0;
					diZhi[names.length-1]=null;
					zongJing[names.length-1]=0.0;
					zhuangTai[names.length-1]=0;
				}
				if(!y){
					System.out.println("该订单号不存在");
				}
				break;
			case 5:
				System.out.println("****我要点赞****");
				System.out.println("序号\t菜名\t单价\t点赞数");
				for(int i=0;i<cais.length;i++){
					String danJ=danJia[i]+"元";
					String zanShu=zan[i]+"赞";
					System.out.println((i+1)+"\t"+cais[i]+"\t"+danJ+"\t"+zanShu);
				}
				System.out.print("请选择您要点的菜品序号:");
				int xuHaoo=input.nextInt();
				zan[xuHaoo-1]++;
				System.out.println("点赞成功");
				System.out.println("所点菜品:"+cais[xuHaoo-1]);
				break;
			case 6:
				break;
				default:
					break;
			}
			if(z>=6){
				//y=false;
				System.out.println("谢谢使用，欢迎下次光临!");
				break;
				}
			if(!y){System.out.print("输入0返回");}
			x=input.nextInt();
		}while(x==0);
		//if(!y){System.out.println("谢谢使用，欢迎下次光临!");}
	}

}
