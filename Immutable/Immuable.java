package Immutable;

//��׼API�еļ���immutableģʽ�Ĺؼ��� ���ɱ��
//String ��  
//�����ֵ�BigInteger �� BigDecimal
//���л�����İ�װ�� Integer Byte...
//��Java�б�ʾ������ʽ��java.util.regex.Pattern�� 
//��ʾ��ɫ��Color��
//note:StringBuffer�ǿɱ�ģ�������StringBuffer��Ϊ������String�Ĺ�������
//StringBufferҲͬʱ����String��Ϊ��ʽ�������빹����
public class Immuable {

	
	final private int count;
     public Immuable(int count) {
    	 this.count=count;
    	 //blank final �÷�
     }
     
     public int get() {
    	 return this.count;
     }
     //��һ���ഴ�����֮�������״̬���ٷ����仯����ʱ������ķ��������֧�ֶ��̷߳��ʣ���������synchronized�ؼ���
     //�������е�ֵ�ڸ�ֵ֮��㲻�ٸı� final�ؼ��ֵ�ʹ�á��Լ��������ṩ�˷����ֶ�����Ҫ��get��������û���ṩ�޸��ֶ���Ҫ��set����
     
}
