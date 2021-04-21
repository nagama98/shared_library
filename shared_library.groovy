import groovy.json.*
//sample
def hello(){
println "Hello world"
}


//list quality gates
def list(){
def conn = null

conn = new URL("http://localhost:9000/api/qualitygates/list").openConnection();
conn.setRequestMethod("GET")
conn.setRequestProperty("Authorization", "Basic YWRtaW46YWRtaW4x")

def postRC = conn.getResponseCode()
def responseText = conn.getInputStream().getText()
JsonSlurper slurper = new JsonSlurper()
responseText = slurper.parseText(responseText) 
     
println(responseText)
}