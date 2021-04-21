import groovy.json.*

def conn = null

conn = new URL("http://localhost:9000/api/qualitygates/set_as_default?name=demo-qualitygate").openConnection();
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

//println(resultMap)

