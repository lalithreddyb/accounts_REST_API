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
  			  sh 'docker tag lalithreddyb/accounts_mongo:${BUILD_NUMBER} 012515449968.dkr.ecr.us-east-1.amazonaws.com/lalith_mongo:latest'   
  	    }  
  stage('Push Image')
  		{         
 			sh 'aws ecr get-login --no-include-email --region us-east-1'
 			 sh 'docker push 012515449968.dkr.ecr.us-east-1.amazonaws.com/lalith_mongo:latest'  
 		}
  }


