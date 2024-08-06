#!/bin/bash

cat $* |
tr [A-Z] [a-z] |
tr -sc "[A-Z][a-z]" "[\n*]" |
sort |
uniq -c |
sort -nr