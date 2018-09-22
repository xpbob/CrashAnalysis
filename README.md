# CrashAnalysis

## 功能介绍  
这是一个jvm crash分析工具，主要分析jvm crash的原因，以及常见的解决手段。
## 使用方式  
java -jar CrashAnalysis-1.0-SNAPSHOT.jar ${hs_err_pid.log}   
${hs_err_pid.log} 是jvm crash后生成的日志。  
## 效果
分析完成后会展示出来诊断信息，其他信息都是用来严重诊断信息的。