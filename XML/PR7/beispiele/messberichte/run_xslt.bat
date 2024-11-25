@echo off

rem So funktioniert das Aufrufen von Xalan-Java in einer Batch-Datei
rem -classpath ..\..\xalan.jar: Verweis auf die jar-Datei
rem org.apache.xalan.xslt.Process: Verweis auf die Java-Klasse
rem -xsltc: Aufruf des XSLT-Compilers
rem -XSL messberichte.xsl: Verweis auf das Stylesheet, muss angegeben werden, wenn nicht im XML-Dokument referenziert
java -classpath ..\..\xalan.jar org.apache.xalan.xslt.Process -xsltc -IN messberichte.xml -XSL messberichte.xsl -OUT messberichte.html -html
pause
