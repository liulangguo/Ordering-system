import java.util.*;
public class DingDan1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] names=new String[4];//����
		String [] canPin=new String[names.length]; //��Ʒ
		int []times=new int[names.length];         //ʱ��
		String []diZhi=new String[names.length];   //��ַ
		double[]zongJing=new double[names.length];//�ܽ��
		int []zhuangTai=new int[names.length];    //״̬
		//��ʼ��
		names[0]="����";
		canPin[0]="�������� 1��";
		times[0]=10;
		diZhi[0]="����Ժ";
		zongJing[0]=21;
		zhuangTai[0]=1;
		
		names[1]="����";
		canPin[1]="�������� 1��";
		times[1]=10;
		diZhi[1]="����Ժ";
		zongJing[1]=21;
		zhuangTai[1]=0;
		//һ���Ʒ
		String[] cais=new String[]{"��������","������","ʱ���߲�"};//����
		double []danJia=new double[]{15,30,10};            //����
		int []zan=new int[3];                              //������
		Scanner input=new Scanner(System.in);
		int x=-1;
		boolean y=false;
		do{
			System.out.println("��ӭʹ�á��Ի����˶���ϵͳ��");
			System.out.println("*************************");
			System.out.println("1.��Ҫ����");
			System.out.println("2.�鿴�ʹ�");
			System.out.println("3.ǩ�ն���");
			System.out.println("4.ɾ������");
			System.out.println("5.��Ҫ����");
			System.out.println("6.�˳�ϵͳ");
			System.out.println("*************************");
			System.out.print("��ѡ��: ");
			int z=input.nextInt();
			switch(z){
			case 1:
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						y=true;
						System.out.println("****��Ҫ����****");
						System.out.print("�����붩��������:");
						String name=input.next();
						System.out.println("���\t����\t����\t������");
						for(int j=0;j<cais.length;j++){
							//System.out.println("�����붩��������:");
							//names[i]=input.next();
							String danJias=danJia[j]+"Ԫ";
							System.out.println((j+1)+"\t"+cais[j]+"\t"+danJias+"\t"+zan[j]);
						}
						System.out.print("��ѡ����Ҫ��Ĳ�Ʒ���:");
						int bianHao=input.nextInt();
						System.out.print("��ѡ������Ҫ�ķ���:");
						int fen=input.nextInt();
						System.out.print("�������Ͳ�ʱ�䣨�Ͳ�ʱ����10����20��������Ͳͣ�:");
						int time=input.nextInt();
						if(times[i]>20||times[i]<10){
							System.out.print("��ʱ��β��Ͳͣ����������");
							times[i]=input.nextInt();
						}
						System.out.print("�������Ͳ͵�ַ");
						String diZhis=input.next();
						System.out.println("���ͳɹ�!");
						String di=cais[i]+fen+"��";//��Ʒ
						System.out.println("��������:"+di);
						System.out.println("�������Ͳ�ʱ��"+times[i]);
						double canFei=danJia[i]*fen;
						double songCan=canFei>50?0:6;
						double zong=canFei+songCan;
						System.out.println("�ͷ�"+canFei+"�Ͳͷ�"+songCan+"�ܼ�"+zong);
						names[i]=name;
						canPin[i]=di;
						times[i]=time;
						diZhi[i]=diZhis;
						zongJing[i]=zong;
					}
				}
				if(!y){
					System.out.println("�ʹ�����");
				}
				break;
			case 2:
				System.out.println("****�鿴�ʹ�****");
				System.out.println("���\t������\t��Ʒ��Ϣ\t\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t\t�ܽ��\t����״̬");
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
					String time=times[i]+"��";
					String zong=zongJing[i]+"Ԫ";
					String zhuangTa=zhuangTai[i]==0?"��Ԥ��":"�����";
					System.out.println((i+1)+"\t"+names[i]+"\t"+canPin[i]+"\t"+"\t"+time+"\t"+diZhi[i]+"\t"+"\t"+zong+"\t"+zhuangTa);
					}
				}
				break;
			case 3:
				System.out.println("****ǩ�ն���****");
				System.out.println("��ѡ��Ҫǩ�յĶ������:");
				int xu=input.nextInt();
				for(int i=0;i<names.length;i++){
					if(names[i]!=null&&xu==i+1&&zhuangTai[i]==1){
						System.out.println("�����޷����ٴ�ǩ��");
						y=true;
						break;
					}else if(names[i]!=null&&xu==i+1&&zhuangTai[i]==0){
						System.out.println("����ǩ�ճɹ�");
						zhuangTai[i]=1;
						y=true;
						break;
					}
				}
				if(!y){
					System.out.println("�ö����Ų�����");
				}
				break;
			case 4:
				System.out.println("****ɾ������****");
				System.out.print("������Ҫɾ���Ķ������:");
				int xuH=input.nextInt();
				int next=-1;
				for(int i=0;i<names.length;i++){
					if(names[i]!=null&&xuH==i+1&&zhuangTai[i]==0){
						System.out.println("��ѡ��Ķ���δǩ��,�޷���ɾ��");
						y=true;
						break;
					}else if(names[i]!=null&&xuH==i+1&&zhuangTai[i]==1){
						next=i;
						y=true;
						break;
					}
				}
			//	if(!y){
				//	System.out.println("�ö����Ų�����");
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
					System.out.println("ɾ���ɹ�");
					names[names.length-1]=null;
					canPin[names.length-1]=null;
					times[names.length-1]=0;
					diZhi[names.length-1]=null;
					zongJing[names.length-1]=0.0;
					zhuangTai[names.length-1]=0;
				}
				if(!y){
					System.out.println("�ö����Ų�����");
				}
				break;
			case 5:
				System.out.println("****��Ҫ����****");
				System.out.println("���\t����\t����\t������");
				for(int i=0;i<cais.length;i++){
					String danJ=danJia[i]+"Ԫ";
					String zanShu=zan[i]+"��";
					System.out.println((i+1)+"\t"+cais[i]+"\t"+danJ+"\t"+zanShu);
				}
				System.out.print("��ѡ����Ҫ��Ĳ�Ʒ���:");
				int xuHaoo=input.nextInt();
				zan[xuHaoo-1]++;
				System.out.println("���޳ɹ�");
				System.out.println("�����Ʒ:"+cais[xuHaoo-1]);
				break;
			case 6:
				break;
				default:
					break;
			}
			if(z>=6){
				//y=false;
				System.out.println("ллʹ�ã���ӭ�´ι���!");
				break;
				}
			if(!y){System.out.print("����0����");}
			x=input.nextInt();
		}while(x==0);
		//if(!y){System.out.println("ллʹ�ã���ӭ�´ι���!");}
	}

}
