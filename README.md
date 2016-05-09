# Software Studio Assignment 6

## Notes
+ You will have to import the libraries on your own. All the libraries are provided on iLMS.
+ Even you followed the design TA shown in the video, you still have to explain the control of the program in the next section.

## Explanation of the Design  

### 操作
+ Add All按鈕可以將此影集的所有角色加入中間的network中
+ Clear按鈕可以移除目前在network中的角色
+ 當滑鼠游標移到角色圓圈上時，會顯示角色名字。
+ 滑鼠可以隨意拖曳一個角色。當滑鼠放開地點在network圓圈內時，會將此角色加入network中。
+ 按下鍵盤數字鍵(右方或上方都可以)1~7可以選擇影集。


### 視覺
+ 游標移到角色圓圈內時，圓圈會放大。移開時會縮小。
+ 當游標拖曳一角色，若可以放在網路內時(在大圓圈內)，則大圓會變色。
+ 網路中，角色連線的寬度與互動次數有關。在實作中其寬度是設定為2*log(value) + 4
+ 當游標移到網路中任何一角色上時，其他不相干角色的網路不會顯示。

##類別設計

### MainApplet.java 

+ setup()
 建立 Network instance 
 使用 loadData() 讀取 JSON檔的資料
 給定一個int參數"theChosenOne" 代表選取的影集數(0~6 分別代表 episode 1~7) (初始是0 代表eposode 1)

+ loadData()中
建立一個ArrayList<ArrayList<Character>> "episode" 用來存放 7個 ArrayList<Character> (每一個ArrayList 放該影集的所有腳色)
並且利用Character 的 method "addTarget(Character, int)" 建立一個HashMap<Character, int>用以存放每個角色會對應到的target以及他們之間的關聯性(value)

+ draw()
分別畫出network(中間網路部分)以及每個腳色
當滑鼠上有物件時且該物件有在網路中，則僅顯示該物件的網路。否則正常顯示網路圖。
當滑鼠上有物件時，則選取的圓圈最後display

+ mouseDragged()
當滑鼠拖曳時，判斷是否有物件。當有物件時，則設定該物件的X，Y座標。

+ mouseReleased()
當滑鼠鍵放開時，判斷是否有物件。當有物件時，判斷是否在network圓圈中。若不是在圓圈中，則使用Character中的fly()方法飛回原處。

+ keyPressed()
當按下數字鍵時會切換影集數

+ initButton()
+ addButton()
+ clearButton()
三者為設定ControlP5按鈕的方法。
addButton()是 Add All按鈕按下時呼叫的方法。將所有的角色利用network中的add方法加入。
clearButton()是Clear All按鈕按下時呼叫的方法。將所有的角色利用network中的removeAll方法移除。

Setter
+ setHasObject(boolean)
+ setObjectOnMouse(Character)

Getter
+ hasObeject(): boolean
+ getObjectOnMouse(): Character

### Character.java

+ display()
畫出角色圓球
當滑鼠游上的物件為該角色時，則顯示角色名字。

+ ntDisplay()
當角色在網路中時，畫出網路。(雙向，自己的目標，及網路中其他角色目標為自己)
※曲線的實作：
利用curve方法，並且設定控制點為該角色與圓點連線向大圓外延伸。

+ fly()
設定MainApplet中的hasObject為false，objectOnMouse為null
並且讓角色圓球由現在位置飛回原始位置。

+ addTarget(Character, int)
將目標角色加入目標ArrayList中

Ani相關：
+ aniSetup()
Ani初始化
+ start()
開始方法。印出"in"。除錯用
+ end()
呼叫時。設定MainApplet中的hasObject為false，objectOnMouse為null

Setter:
+ setX(float)
+ setY(float)
+ setInNetwork(boolean)

Getter:
+ getTargets(): HashMap<Character,Integer>

### Network.java
ArrayList characters: 用來儲存在網路中的角色

+ display()
畫出大圓
若游標上有物件且在大圓半徑內，則變換顏色

+ reArrange()
根據此類別中ArrayList內角色的數量，來設定座標。

+ add(Character)
加入參數角色到characters中，並且呼叫reArrange()

+ remove(Character)
將characters中的參數角色移除。並且呼叫reArrange()

+ removeAll()
設定characters中每個角色的inNetwork屬性為false
呼叫characters中每個角色的fly()
並且移除characters中的所有角色，

Getter:
+ getRadius(): int
+ getX(): float
+ getY(): float
+ getNetworkCh(): ArrayList<Character>


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
