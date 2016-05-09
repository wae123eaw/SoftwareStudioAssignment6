# Software Studio Assignment 6

## Notes
+ You will have to import the libraries on your own. All the libraries are provided on iLMS.
+ Even you followed the design TA shown in the video, you still have to explain the control of the program in the next section.

## Explanation of the Design  

### ¾Þ§@
+ Add All«ö¶s¥i¥H±N¦¹¼v¶°ªº©Ò¦³¨¤¦â¥[¤J¤¤¶¡ªºnetwork¤¤
+ Clear«ö¶s¥i¥H²¾°£¥Ø«e¦bnetwork¤¤ªº¨¤¦â
+ ·í·Æ¹«´å¼Ð²¾¨ì¨¤¦â¶ê°é¤W®É¡A·|Åã¥Ü¨¤¦â¦W¦r¡C
+ ·Æ¹«¥i¥HÀH·N©ì¦²¤@­Ó¨¤¦â¡C·í·Æ¹«©ñ¶}¦aÂI¦bnetwork¶ê°é¤º®É¡A·|±N¦¹¨¤¦â¥[¤Jnetwork¤¤¡C
+ «ö¤UÁä½L¼Æ¦rÁä(¥k¤è©Î¤W¤è³£¥i¥H)1~7¥i¥H¿ï¾Ü¼v¶°¡C


### µøÄ±
+ ´å¼Ð²¾¨ì¨¤¦â¶ê°é¤º®É¡A¶ê°é·|©ñ¤j¡C²¾¶}®É·|ÁY¤p¡C
+ ·í´å¼Ð©ì¦²¤@¨¤¦â¡A­Y¥i¥H©ñ¦bºô¸ô¤º®É(¦b¤j¶ê°é¤º)¡A«h¤j¶ê·|ÅÜ¦â¡C
+ ºô¸ô¤¤¡A¨¤¦â³s½uªº¼e«×»P¤¬°Ê¦¸¼Æ¦³Ãö¡C¦b¹ê§@¤¤¨ä¼e«×¬O³]©w¬°2*log(value) + 4
+ ·í´å¼Ð²¾¨ìºô¸ô¤¤¥ô¦ó¤@¨¤¦â¤W®É¡A¨ä¥L¤£¬Û¤z¨¤¦âªººô¸ô¤£·|Åã¥Ü¡C

##Ãþ§O³]­p

### MainApplet.java 

+ setup()
 «Ø¥ß Network instance 
 ¨Ï¥Î loadData() Åª¨ú JSONÀÉªº¸ê®Æ
 µ¹©w¤@­Óint°Ñ¼Æ"theChosenOne" ¥Nªí¿ï¨úªº¼v¶°¼Æ(0~6 ¤À§O¥Nªí episode 1~7) (ªì©l¬O0 ¥Nªíeposode 1)

+ loadData()¤¤
«Ø¥ß¤@­ÓArrayList<ArrayList<Character>> "episode" ¥Î¨Ó¦s©ñ 7­Ó ArrayList<Character> (¨C¤@­ÓArrayList ©ñ¸Ó¼v¶°ªº©Ò¦³¸}¦â)
¨Ã¥B§Q¥ÎCharacter ªº method "addTarget(Character, int)" «Ø¥ß¤@­ÓHashMap<Character, int>¥Î¥H¦s©ñ¨C­Ó¨¤¦â·|¹ïÀ³¨ìªºtarget¥H¤Î¥L­Ì¤§¶¡ªºÃöÁp©Ê(value)

+ draw()
¤À§Oµe¥Xnetwork(¤¤¶¡ºô¸ô³¡¤À)¥H¤Î¨C­Ó¸}¦â
·í·Æ¹«¤W¦³ª«¥ó®É¥B¸Óª«¥ó¦³¦bºô¸ô¤¤¡A«h¶ÈÅã¥Ü¸Óª«¥óªººô¸ô¡C§_«h¥¿±`Åã¥Üºô¸ô¹Ï¡C
·í·Æ¹«¤W¦³ª«¥ó®É¡A«h¿ï¨úªº¶ê°é³Ì«ádisplay

+ mouseDragged()
·í·Æ¹«©ì¦²®É¡A§PÂ_¬O§_¦³ª«¥ó¡C·í¦³ª«¥ó®É¡A«h³]©w¸Óª«¥óªºX¡AY®y¼Ð¡C

+ mouseReleased()
·í·Æ¹«Áä©ñ¶}®É¡A§PÂ_¬O§_¦³ª«¥ó¡C·í¦³ª«¥ó®É¡A§PÂ_¬O§_¦bnetwork¶ê°é¤¤¡C­Y¤£¬O¦b¶ê°é¤¤¡A«h¨Ï¥ÎCharacter¤¤ªºfly()¤èªk­¸¦^­ì³B¡C

+ keyPressed()
·í«ö¤U¼Æ¦rÁä®É·|¤Á´«¼v¶°¼Æ

+ initButton()
+ addButton()
+ clearButton()
¤TªÌ¬°³]©wControlP5«ö¶sªº¤èªk¡C
addButton()¬O Add All«ö¶s«ö¤U®É©I¥sªº¤èªk¡C±N©Ò¦³ªº¨¤¦â§Q¥Înetwork¤¤ªºadd¤èªk¥[¤J¡C
clearButton()¬OClear All«ö¶s«ö¤U®É©I¥sªº¤èªk¡C±N©Ò¦³ªº¨¤¦â§Q¥Înetwork¤¤ªºremoveAll¤èªk²¾°£¡C

Setter
+ setHasObject(boolean)
+ setObjectOnMouse(Character)

Getter
+ hasObeject(): boolean
+ getObjectOnMouse(): Character

### Character.java

+ display()
µe¥X¨¤¦â¶ê²y
·í·Æ¹«´å¤Wªºª«¥ó¬°¸Ó¨¤¦â®É¡A«hÅã¥Ü¨¤¦â¦W¦r¡C

+ ntDisplay()
·í¨¤¦â¦bºô¸ô¤¤®É¡Aµe¥Xºô¸ô¡C(Âù¦V¡A¦Û¤vªº¥Ø¼Ð¡A¤Îºô¸ô¤¤¨ä¥L¨¤¦â¥Ø¼Ð¬°¦Û¤v)
¡°¦±½uªº¹ê§@¡G
§Q¥Îcurve¤èªk¡A¨Ã¥B³]©w±±¨îÂI¬°¸Ó¨¤¦â»P¶êÂI³s½u¦V¤j¶ê¥~©µ¦ù¡C

+ fly()
³]©wMainApplet¤¤ªºhasObject¬°false¡AobjectOnMouse¬°null
¨Ã¥BÅý¨¤¦â¶ê²y¥Ñ²{¦b¦ì¸m­¸¦^­ì©l¦ì¸m¡C

+ addTarget(Character, int)
±N¥Ø¼Ð¨¤¦â¥[¤J¥Ø¼ÐArrayList¤¤

Ani¬ÛÃö¡G
+ aniSetup()
Aniªì©l¤Æ
+ start()
¶}©l¤èªk¡C¦L¥X"in"¡C°£¿ù¥Î
+ end()
©I¥s®É¡C³]©wMainApplet¤¤ªºhasObject¬°false¡AobjectOnMouse¬°null

Setter:
+ setX(float)
+ setY(float)
+ setInNetwork(boolean)

Getter:
+ getTargets(): HashMap<Character,Integer>

### Network.java
ArrayList characters: ¥Î¨ÓÀx¦s¦bºô¸ô¤¤ªº¨¤¦â

+ display()
µe¥X¤j¶ê
­Y´å¼Ð¤W¦³ª«¥ó¥B¦b¤j¶ê¥b®|¤º¡A«hÅÜ´«ÃC¦â

+ reArrange()
®Ú¾Ú¦¹Ãþ§O¤¤ArrayList¤º¨¤¦âªº¼Æ¶q¡A¨Ó³]©w®y¼Ð¡C

+ add(Character)
¥[¤J°Ñ¼Æ¨¤¦â¨ìcharacters¤¤¡A¨Ã¥B©I¥sreArrange()

+ remove(Character)
±Ncharacters¤¤ªº°Ñ¼Æ¨¤¦â²¾°£¡C¨Ã¥B©I¥sreArrange()

+ removeAll()
³]©wcharacters¤¤¨C­Ó¨¤¦âªºinNetworkÄÝ©Ê¬°false
©I¥scharacters¤¤¨C­Ó¨¤¦âªºfly()
¨Ã¥B²¾°£characters¤¤ªº©Ò¦³¨¤¦â¡A

Getter:
+ getRadius(): int
+ getX(): float
+ getY(): float
+ getNetworkCh(): ArrayList<Character>

<<<<<<< HEAD
##¹ê§@¤¤¹J¨ìªº°ÝÃD
runtime°õ¦æ®É¦³¹J¨ìConcurrentModificationExceptionªº°ÝÃD¡C
¤Wºô¤j­P¬d¸ß¤@¤U¡A­Ó¤H¹ï³o­Ó¿ù»~»¤µoªº²z¸Ñ¬O¡G
iterator¦bÅª¨ú¸ê®Æ®É·|ÀË¬d¸ê®Æªº¼Æ¶q¡C
¦pªG¨ä¥Lthread¦³°Ê¨ì­ì©l¸ê®Æ¡A§ïÅÜ¨ä¸ê®Æ¼Æ¶qªº¸Ü¡Aiterator¦b¶i¦æ¤U¦¸Åª¨ú®É·|µo²{¸ê®Æ¼Æ¶q¤£¤@­P¡A¦Ó¥á¥X¨º­Ó¿ù»~¡C
¦Ó¤j³¡¤Àºô¸ô¤W¬d¨ìªºª¬ªp¬O¦bremoveªº®É­Ô·|»¤µo¿ù»~¡C
¦ý§Ú­Ì¤@¶}©l¹J¨ì³o­Ó°ÝÃD¬O¦bÅª¨ú®É²£¥Íªº¡C
³Ìªìªº³]­p¬O¥u§Q¥Î¤@­ÓArrayList¥hÅª¨úJASONÀÉ¡CÅª¨ú¸ê®Æ¬O¦bÁä½L¯Ã«ö¤U«á¡A¶}¤@­Ó·sªºarrayList¡A±N¸ê®ÆÅª¶i¨Ó¡C³o­Ó³]­p¤U¡A¦b°µ§Ö³tªº¼v¶°¤Á´«®É¡A·|»¤µo°ÝÃD¡C
«á¨Ó§Q¥Î7­ÓArrayList¨Ó¦s¸ê®Æ¡A¦³§ïµ½«e­±ªº°ÝÃD¡C
«áÄò´ú¸Õ¤¤¡AÂIÀ»Add All ¨Ã¥B¤Á´«¼v¶°®É¡A¤S·|»¤µo¸Ó¿ù»~¡C
¦]¦¹¹Á¸Õ±Ncharacter¤¤ntDisplayÅª¨ú¸ê®Æªº¤èªk(­ì¥»¬O§Q¥Îenhanced loop)¡A­×§ï¬°§Q¥Îfor(int i;i<characters.size();i++)¤è¦¡¨ÓÅª¨ú¡A°ÝÃD´N¸Ñ¨M¤F¡C
¤£¹L¡A¤£²M·¡³o¼Ëªº¸Ñ¨M¤è¦¡¹ï¤£¹ï¡AºI¦Ü¥Ø«e¬°¤î´ú¸Õ¬O¨S¦³°ÝÃDªº¡C
=======
##å¯¦ä½œä¸­é‡åˆ°çš„å•é¡Œ
runtimeåŸ·è¡Œæ™‚æœ‰é‡åˆ°ConcurrentModificationExceptionçš„å•é¡Œã€‚
ä¸Šç¶²å¤§è‡´æŸ¥è©¢ä¸€ä¸‹ï¼Œå€‹äººå°é€™å€‹éŒ¯èª¤èª˜ç™¼çš„ç†è§£æ˜¯ï¼š
iteratoråœ¨è®€å–è³‡æ–™æ™‚æœƒæª¢æŸ¥è³‡æ–™çš„æ•¸é‡ã€‚
å¦‚æžœå…¶ä»–threadæœ‰å‹•åˆ°åŽŸå§‹è³‡æ–™ï¼Œæ”¹è®Šå…¶è³‡æ–™æ•¸é‡çš„è©±ï¼Œiteratoråœ¨é€²è¡Œä¸‹æ¬¡è®€å–æ™‚æœƒç™¼ç¾è³‡æ–™æ•¸é‡ä¸ä¸€è‡´ï¼Œè€Œä¸Ÿå‡ºé‚£å€‹éŒ¯èª¤ã€‚
è€Œå¤§éƒ¨åˆ†ç¶²è·¯ä¸ŠæŸ¥åˆ°çš„ç‹€æ³æ˜¯åœ¨removeçš„æ™‚å€™æœƒèª˜ç™¼éŒ¯èª¤ã€‚
ä½†æˆ‘å€‘ä¸€é–‹å§‹é‡åˆ°é€™å€‹å•é¡Œæ˜¯åœ¨è®€å–æ™‚ç”¢ç”Ÿçš„ã€‚
æœ€åˆçš„è¨­è¨ˆæ˜¯åªåˆ©ç”¨ä¸€å€‹ArrayListåŽ»è®€å–JASONæª”ã€‚è®€å–è³‡æ–™æ˜¯åœ¨éµç›¤ç´æŒ‰ä¸‹å¾Œï¼Œé–‹ä¸€å€‹æ–°çš„arrayListï¼Œå°‡è³‡æ–™è®€é€²ä¾†ã€‚é€™å€‹è¨­è¨ˆä¸‹ï¼Œåœ¨åšå¿«é€Ÿçš„å½±é›†åˆ‡æ›æ™‚ï¼Œæœƒèª˜ç™¼å•é¡Œã€‚
å¾Œä¾†åˆ©ç”¨7å€‹ArrayListä¾†å­˜è³‡æ–™ï¼Œæœ‰æ”¹å–„å‰é¢çš„å•é¡Œã€‚
å¾ŒçºŒæ¸¬è©¦ä¸­ï¼Œé»žæ“ŠAdd All ä¸¦ä¸”åˆ‡æ›å½±é›†æ™‚ï¼Œåˆæœƒèª˜ç™¼è©²éŒ¯èª¤ã€‚
å› æ­¤å˜—è©¦å°‡characterä¸­ntDisplayè®€å–è³‡æ–™çš„æ–¹æ³•(åŽŸæœ¬æ˜¯åˆ©ç”¨enhanced loop)ï¼Œä¿®æ”¹ç‚ºåˆ©ç”¨for(int i;i<characters.size();i++)æ–¹å¼ä¾†è®€å–ï¼Œå•é¡Œå°±è§£æ±ºäº†ã€‚
ä¸éŽï¼Œä¸æ¸…æ¥šé€™æ¨£çš„è§£æ±ºæ–¹å¼å°ä¸å°ï¼Œæˆªè‡³ç›®å‰ç‚ºæ­¢æ¸¬è©¦æ˜¯æ²’æœ‰å•é¡Œçš„ã€‚
>>>>>>> baaae61002318f31d8dac95b56b2e01c2fd9b7fa
