##Unusual Templates For Confluence

This project created to show you a different approaches of how things should work.

Creative Plugins are organised to introduce a bunch of different approaches. Things could be done easily and plugins can be managed simply too.

###ToDo:
1. Resolve WebPack Problems
1. Add Env Support
1. Add Linters
1. Add Client build as part of Maven lifecycle

####Prerequisites:
1. nodeJS
1. Atlassian SDK
1. jdk8 

###How to Build:

```
cd src/client
npm install
npm run dev
cd ../../
atlas-mvn package
```
