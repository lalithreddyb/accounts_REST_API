node 
{     
   stage('pulling code from git')
   		{         
   			checkout scm    
   	    } 
   	    
   stage ('build stage')
   		{
   			sh 'mvn clean install'
   		}
   		
   
   stage('Build Image')
  	    {        
  			  sh 'sudo docker build -t lalithreddyb/AccountsRESTAPI:${BUILD_NUMBER} .'   
  			  sh 'docker tag lalithreddyb/AccountsRESTAPI:${BUILD_NUMBER} lalithreddyb/AccountsRESTAPI:latest'   
  	    }  
  stage('Push Image')
  		{         
 			 sh 'docker login -u lalithreddy -p lalith@143'    
 			 sh 'docker push lalithreddyb/AccountsRESTAPI:latest'  
 		}
  }


