#/bin/bash
xmllint -valid -noout messberichte_dtd_extern.xml
if [ -z "$echo"  ]; then echo  "Alles OK"
    exit 1
fi
