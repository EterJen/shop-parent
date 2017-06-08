<html>
<body>
<h1> age is --->  ${age} </h1>
<br/>
<br/>
<br/>
<br/>
<br/>
[#--freemarker 宏指令 --]
[#include "macro.ftl"/]
[@greet person="老高"][/@greet]<br/>
-------------------------------<br/>
<br/>
<br/>
<br/>
<br/>
[#--freemarker 宏指令 别名 --]
[#import 'macro.ftl' as m1]
[#import 'macro2.ftl' as m2]
[@m1.greet person='老裴'][/@m1.greet]<br/>
[@m2.greet person='老裴'][/@m2.greet]<br/>
------------------<br/>
<br/>
<br/>
<br/>
<br/>
[#--freemarker自定义指令--]
[@hello name = "老" age=20]
name is ${params.name} <br/>
age is ${params.age}
[/@hello]<br/>
<br/>
<br/>
<br/>
[@hello name = "老裴" age=20 com="com.shsxt"]
[/@hello]<br/>
<br/>
<br/>
</body>
</html>