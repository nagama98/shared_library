import groovy.json.*
//sample
def call(){
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


//create quality gate

def create(def name)
{

def conn = null

conn = new URL("http://localhost:9000/api/qualitygates/create?name="+name+"").openConnection();
conn.setRequestMethod("POST")
conn.setRequestProperty("Authorization", "Basic YWRtaW46YWRtaW4x")
conn.setDoOutput(true)
        
OutputStream os = conn.getOutputStream();
//os.write(body.getBytes("UTF-8"));
os.write();
os.flush();
os.close();


def bufferedReader = new BufferedReader(new InputStreamReader( conn.getInputStream()))
    
def slurper = new JsonSlurper()
def resultMap = slurper.parseText(bufferedReader.getText())

println(resultMap)

     
}


//create condition

def create_condition(def error,def name,def metric, def op)
{
    def conn = null

conn = new URL("http://localhost:9000/api/qualitygates/create_condition?error="+error+"&gateName="+name+"&metric="+metric+"&op="+op+"").openConnection();
conn.setRequestMethod("POST")
conn.setRequestProperty("Authorization", "Basic YWRtaW46YWRtaW4x")
conn.setDoOutput(true)
        
OutputStream os = conn.getOutputStream();
//os.write(body.getBytes("UTF-8"));
os.write();
os.flush();
os.close();


def bufferedReader = new BufferedReader(new InputStreamReader( conn.getInputStream()))
    
def slurper = new JsonSlurper()
def resultMap = slurper.parseText(bufferedReader.getText())

println(resultMap)


}
