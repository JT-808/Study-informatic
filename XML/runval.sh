#/bin/bash
xmllint -valid -noout biblio.xml
if [ -z "$echo"  ]; then
    echo  "Alles OK"
    exit 1
fi
