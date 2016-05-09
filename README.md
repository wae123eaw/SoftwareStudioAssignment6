# Software Studio Assignment 6

## Notes
+ You will have to import the libraries on your own. All the libraries are provided on iLMS.
+ Even you followed the design TA shown in the video, you still have to explain the control of the program in the next section.

## Explanation of the Design  

### �ާ@
+ Add All���s�i�H�N���v�����Ҧ�����[�J������network��
+ Clear���s�i�H�����ثe�bnetwork��������
+ ��ƹ���в��쨤����W�ɡA�|��ܨ���W�r�C
+ �ƹ��i�H�H�N�즲�@�Ө���C��ƹ���}�a�I�bnetwork��餺�ɡA�|�N������[�Jnetwork���C
+ ���U��L�Ʀr��(�k��ΤW�賣�i�H)1~7�i�H��ܼv���C


### ��ı
+ ��в��쨤���餺�ɡA���|��j�C���}�ɷ|�Y�p�C
+ ���Щ즲�@����A�Y�i�H��b��������(�b�j��餺)�A�h�j��|�ܦ�C
+ �������A����s�u���e�׻P���ʦ��Ʀ����C�b��@����e�׬O�]�w��2*log(value) + 4
+ ���в������������@����W�ɡA��L���ۤz���⪺�������|��ܡC

##���O�]�p

### MainApplet.java 

+ setup()
 �إ� Network instance 
 �ϥ� loadData() Ū�� JSON�ɪ����
 ���w�@��int�Ѽ�"theChosenOne" �N�������v����(0~6 ���O�N�� episode 1~7) (��l�O0 �N��eposode 1)

+ loadData()��
�إߤ@��ArrayList<ArrayList<Character>> "episode" �ΨӦs�� 7�� ArrayList<Character> (�C�@��ArrayList ��Ӽv�����Ҧ��}��)
�åB�Q��Character �� method "addTarget(Character, int)" �إߤ@��HashMap<Character, int>�ΥH�s��C�Ө���|�����쪺target�H�ΥL�̤��������p��(value)

+ draw()
���O�e�Xnetwork(������������)�H�ΨC�Ӹ}��
��ƹ��W������ɥB�Ӫ��󦳦b�������A�h����ܸӪ��󪺺����C�_�h���`��ܺ����ϡC
��ƹ��W������ɡA�h��������̫�display

+ mouseDragged()
��ƹ��즲�ɡA�P�_�O�_������C������ɡA�h�]�w�Ӫ���X�AY�y�СC

+ mouseReleased()
��ƹ����}�ɡA�P�_�O�_������C������ɡA�P�_�O�_�bnetwork��餤�C�Y���O�b��餤�A�h�ϥ�Character����fly()��k���^��B�C

+ keyPressed()
����U�Ʀr��ɷ|�����v����

+ initButton()
+ addButton()
+ clearButton()
�T�̬��]�wControlP5���s����k�C
addButton()�O Add All���s���U�ɩI�s����k�C�N�Ҧ�������Q��network����add��k�[�J�C
clearButton()�OClear All���s���U�ɩI�s����k�C�N�Ҧ�������Q��network����removeAll��k�����C

Setter
+ setHasObject(boolean)
+ setObjectOnMouse(Character)

Getter
+ hasObeject(): boolean
+ getObjectOnMouse(): Character

### Character.java

+ display()
�e�X�����y
��ƹ���W�����󬰸Ө���ɡA�h��ܨ���W�r�C

+ ntDisplay()
����b�������ɡA�e�X�����C(���V�A�ۤv���ؼСA�κ�������L����ؼЬ��ۤv)
�����u����@�G
�Q��curve��k�A�åB�]�w�����I���Ө���P���I�s�u�V�j��~�����C

+ fly()
�]�wMainApplet����hasObject��false�AobjectOnMouse��null
�åB�������y�Ѳ{�b��m���^��l��m�C

+ addTarget(Character, int)
�N�ؼШ���[�J�ؼ�ArrayList��

Ani�����G
+ aniSetup()
Ani��l��
+ start()
�}�l��k�C�L�X"in"�C������
+ end()
�I�s�ɡC�]�wMainApplet����hasObject��false�AobjectOnMouse��null

Setter:
+ setX(float)
+ setY(float)
+ setInNetwork(boolean)

Getter:
+ getTargets(): HashMap<Character,Integer>

### Network.java
ArrayList characters: �Ψ��x�s�b������������

+ display()
�e�X�j��
�Y��ФW������B�b�j��b�|���A�h�ܴ��C��

+ reArrange()
�ھڦ����O��ArrayList�����⪺�ƶq�A�ӳ]�w�y�СC

+ add(Character)
�[�J�Ѽƨ����characters���A�åB�I�sreArrange()

+ remove(Character)
�Ncharacters�����Ѽƨ��Ⲿ���C�åB�I�sreArrange()

+ removeAll()
�]�wcharacters���C�Ө��⪺inNetwork�ݩʬ�false
�I�scharacters���C�Ө��⪺fly()
�åB����characters�����Ҧ�����A

Getter:
+ getRadius(): int
+ getX(): float
+ getY(): float
+ getNetworkCh(): ArrayList<Character>

<<<<<<< HEAD
##��@���J�쪺���D
runtime����ɦ��J��ConcurrentModificationException�����D�C
�W���j�P�d�ߤ@�U�A�ӤH��o�ӿ��~���o���z�ѬO�G
iterator�bŪ����Ʈɷ|�ˬd��ƪ��ƶq�C
�p�G��Lthread���ʨ��l��ơA���ܨ��Ƽƶq���ܡAiterator�b�i��U��Ū���ɷ|�o�{��Ƽƶq���@�P�A�ӥ�X���ӿ��~�C
�Ӥj���������W�d�쪺���p�O�bremove���ɭԷ|���o���~�C
���ڭ̤@�}�l�J��o�Ӱ��D�O�bŪ���ɲ��ͪ��C
�̪쪺�]�p�O�u�Q�Τ@��ArrayList�hŪ��JASON�ɡCŪ����ƬO�b��L�ë��U��A�}�@�ӷs��arrayList�A�N���Ū�i�ӡC�o�ӳ]�p�U�A�b���ֳt���v�������ɡA�|���o���D�C
��ӧQ��7��ArrayList�Ӧs��ơA���ﵽ�e�������D�C
������դ��A�I��Add All �åB�����v���ɡA�S�|���o�ӿ��~�C
�]�����ձNcharacter��ntDisplayŪ����ƪ���k(�쥻�O�Q��enhanced loop)�A�קאּ�Q��for(int i;i<characters.size();i++)�覡��Ū���A���D�N�ѨM�F�C
���L�A���M���o�˪��ѨM�覡�藍��A�I�ܥثe������լO�S�����D���C
=======
##實作中遇到的問題
runtime執行時有遇到ConcurrentModificationException的問題。
上網大致查詢一下，個人對這個錯誤誘發的理解是：
iterator在讀取資料時會檢查資料的數量。
如果其他thread有動到原始資料，改變其資料數量的話，iterator在進行下次讀取時會發現資料數量不一致，而丟出那個錯誤。
而大部分網路上查到的狀況是在remove的時候會誘發錯誤。
但我們一開始遇到這個問題是在讀取時產生的。
最初的設計是只利用一個ArrayList去讀取JASON檔。讀取資料是在鍵盤紐按下後，開一個新的arrayList，將資料讀進來。這個設計下，在做快速的影集切換時，會誘發問題。
後來利用7個ArrayList來存資料，有改善前面的問題。
後續測試中，點擊Add All 並且切換影集時，又會誘發該錯誤。
因此嘗試將character中ntDisplay讀取資料的方法(原本是利用enhanced loop)，修改為利用for(int i;i<characters.size();i++)方式來讀取，問題就解決了。
不過，不清楚這樣的解決方式對不對，截至目前為止測試是沒有問題的。
>>>>>>> baaae61002318f31d8dac95b56b2e01c2fd9b7fa
