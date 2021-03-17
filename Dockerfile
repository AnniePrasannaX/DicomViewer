FROM openjdk:8
EXPOSE 8443
ADD target/DicomViewer.jar DicomViewer.jar 
ENTRYPOINT ["java","-jar","/DicomViewer.jar"]
