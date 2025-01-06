#/bin/bash
xmllint -valid -noout rss.xml
if [ -z "$echo"  ]; then echo  "Alles OK"
    exit 1
fi
