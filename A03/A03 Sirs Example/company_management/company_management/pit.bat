@ECHO OFF
set abort=0
IF "%JAVA_HOME%"=="" (
    ECHO.
    ECHO ***Environment variable JAVA_HOME Not Defined - please correct - terminating
    set abort=1
)
IF "%TESTJAR_HOME%"=="" (
    ECHO.
    ECHO ***Environment variable TESTJAR_HOME Not Defined - please correct - terminating
    set abort=1
)
IF "%PITJAR_HOME%"=="" (
    ECHO.
    ECHO ***Environment variable PITJAR_HOME Not Defined - please correct - terminating
    set abort=1
)
IF "%TOMCAT_LIB%"=="" (
    ECHO.
    ECHO ***Environment variable TOMCAT_LIB Not Defined - please correct - terminating
    set abort=1
)
IF "%abort%"=="1" GOTO:eof
ECHO ON
java -cp "%PITJAR_HOME%\pitest-command-line-1.4.6.jar";"%PITJAR_HOME%\pitest-1.4.6.jar";"%PITJAR_HOME%\pitest-entry-1.4.6.jar";"%TESTJAR_HOME%\junit.jar";"%TESTJAR_HOME%\org.hamcrest.core_1.3.0.v20180420-1519.jar";"%TESTJAR_HOME%\easymock-3.4.jar";"%TESTJAR_HOME%\JUnitParams-1.0.4.jar";"%TESTJAR_HOME%\selenium-server-standalone-3.12.0.jar";"%TOMCAT_LIB%\annotations-api.jar";"%TOMCAT_LIB%\catalina-ha.jar";"%TOMCAT_LIB%\catalina-ssi.jar";"%TOMCAT_LIB%\catalina-storeconfig.jar";"%TOMCAT_LIB%\catalina-tribes.jar";"%TOMCAT_LIB%\catalina.jar";"%TOMCAT_LIB%\ecj-4.13.jar";"%TOMCAT_LIB%\el-api.jar";"%TOMCAT_LIB%\jasper-el.jar";"%TOMCAT_LIB%\jasper.jar";"%TOMCAT_LIB%\jaspic-api.jar";"%TOMCAT_LIB%\jsp-api.jar";"%TOMCAT_LIB%\mysql-connector-java-5.1.48-bin.jar";"%TOMCAT_LIB%\mysql-connector-java-5.1.48.jar";"%TOMCAT_LIB%\org.jacoco.agent_0.8.1.v20180329-2024.jar";"%TOMCAT_LIB%\servlet-api.jar";"%TOMCAT_LIB%\tomcat-api.jar";"%TOMCAT_LIB%\tomcat-coyote.jar";"%TOMCAT_LIB%\tomcat-dbcp.jar";"%TOMCAT_LIB%\tomcat-i18n-es.jar";"%TOMCAT_LIB%\tomcat-jdbc.jar";"%TOMCAT_LIB%\tomcat-jni.jar";"%TOMCAT_LIB%\tomcat-util-scan.jar";"%TOMCAT_LIB%\tomcat-util.jar";"%TOMCAT_LIB%\tomcat-websocket.jar";"%TOMCAT_LIB%\websocket-api.jar";build\classes   org.pitest.mutationtest.commandline.MutationCoverageReport  --reportDir=pitResults  --targetClasses=company_management.model.Company,company_management.model.CompanyErrorMsgs,company_management.model.Employee,company_management.model.EmployeeErrorMsgs  --sourceDirs="\\DISKSTATION\Family_Folder\John\Eclipse JEE workspace\company_management\src" --verbose=true --failWhenNoMutations=false --mutators=CONSTRUCTOR_CALLS,NON_VOID_METHOD_CALLS,CONDITIONALS_BOUNDARY,INCREMENTS,INVERT_NEGS,MATH,RETURN_VALS,VOID_METHOD_CALLS,EMPTY_RETURNS,FALSE_RETURNS,INLINE_CONSTS,NULL_RETURNS,PRIMITIVE_RETURNS,REMOVE_CONDITIONALS,REMOVE_INCREMENTS,TRUE_RETURNS,EXPERIMENTAL_ARGUMENT_PROPAGATION,EXPERIMENTAL_BIG_INTEGER,EXPERIMENTAL_NAKED_RECEIVER,EXPERIMENTAL_MEMBER_VARIABLE,EXPERIMENTAL_SWITCH,AOD,OBBN --excludedClasses=*Test --targetTests=company_management.model.*