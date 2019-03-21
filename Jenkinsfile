node 
{     
   stage('pulling code from git')
   		{         
   			checkout scm    
   	    } 
   	    
   stage ('build stage')
   		{
   			sh '/opt/apache-maven-3.6.0/bin/mvn install'
   		}
   		
   
   stage('Build Image')
  	    {        
  			  sh 'sudo docker build -t lalithreddyb/accounts_mongo:${BUILD_NUMBER} .'   
  			  sh 'docker tag lalithreddyb/accounts_mongo:${BUILD_NUMBER} lalithreddyb:mongo'   
  	    }  
  stage('Push Image')
  		{         
 			 sh 'docker login -u lalithreddy -p Lalith@143'    
 			 sh 'docker push lalithreddyb:mongo'  
 		}
  }


