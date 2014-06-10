java-dynamic-load-jar
=====================

Solve class loader isolation problem when load same classes in different jar

###Introduce

[java-dynamic-loader-common](https://github.com/Trinea/java-dynamic-load-jar/tree/master/java-dynamic-loader-common)  
only CommonClass.java  
  
[java-dynamic-loader-jar1](https://github.com/Trinea/java-dynamic-load-jar/tree/master/java-dynamic-loader-jar1)  
1. ChildCommonClass1.java extend CommonClass  
2. ClassJar1.java contains CommonClass field
  
[java-dynamic-loader-jar2](https://github.com/Trinea/java-dynamic-load-jar/tree/master/java-dynamic-loader-jar2)  
1. ChildCommonClass2.java extend CommonClass  
2. ClassJar2.java contains CommonClass field
  
[java-dynamic-loader-host](https://github.com/Trinea/java-dynamic-load-jar/tree/master/java-dynamic-loader-host)  
1. JarClassLoader.java to load jar1 and jar2  
2. HostMain.java to test  
A. CommonClass loaded from jar1 and jar2 are equals  
B. ChildCommonClass1 or ChildCommonClass2 can be reflected to CommonClass in host normaly  
C. ClassJar1.java or ClassJar2.java those contains CommonClass field can be reflected and running normal.

###Run
Loading projects to eclipse, run `java-dynamic-loader-host` as a Java Application

###Android
It's simple in java, but not work for testB and testC on android, because dalvik will pre-verification
```xml
17:28:36.095: E/PluginDexClassLoader(1464): support class is loading.cn.trinea.java.dynamic.load.common.CommonClass, current loader:1110431216, commmon lib loader:1108712248, clazz:1110549272
17:28:36.095: W/dalvikvm(1464): Class resolved by unexpected DEX: Lcn/trinea/java/dynamic/load/jar1/ChildCommonClass1;(0x422fd5f0):0x6838f000 ref [Lcn/trinea/java/dynamic/load/common/CommonClass;] Lcn/trinea/java/dynamic/load/common/CommonClass;(0x42159b38):0x65ae6000
17:28:36.095: W/dalvikvm(1464): (Lcn/trinea/java/dynamic/load/jar1/ChildCommonClass1; had used a different Lcn/trinea/java/dynamic/load/common/CommonClass; during pre-verification)
17:28:36.095: W/dalvikvm(1464): Unable to resolve superclass of Lcn/trinea/java/dynamic/load/jar1/ChildCommonClass1; (993)
17:28:36.095: W/dalvikvm(1464): Link of class 'Lcn/trinea/java/dynamic/load/jar1/ChildCommonClass1;' failed
17:28:36.095: W/dalvikvm(1464): threadid=1: thread exiting with uncaught exception (group=0x416fb498)
17:28:36.095: E/AndroidRuntime(1464): FATAL EXCEPTION: main
17:28:36.095: E/AndroidRuntime(1464): java.lang.IllegalAccessError: Class ref in pre-verified class resolved to unexpected implementation
17:28:36.095: E/AndroidRuntime(1464): 	at dalvik.system.DexFile.defineClass(Native Method)
17:28:36.095: E/AndroidRuntime(1464): 	at dalvik.system.DexFile.loadClassBinaryName(DexFile.java:211)
17:28:36.095: E/AndroidRuntime(1464): 	at dalvik.system.DexPathList.findClass(DexPathList.java:315)
17:28:36.095: E/AndroidRuntime(1464): 	at dalvik.system.BaseDexClassLoader.findClass(BaseDexClassLoader.java:58)
17:28:36.095: E/AndroidRuntime(1464): 	at java.lang.ClassLoader.loadClass(ClassLoader.java:501)
```


## License

    Copyright 2014 trinea.cn

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.