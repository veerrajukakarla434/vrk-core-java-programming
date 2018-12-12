/**
 * 
 */


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.data.couchbase.repository.config.RepositoryOperationsMapping;
import org.springframework.stereotype.Component;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.vrk.couchbase.entity.Employee;

/**
 * @author Veerraju Kakarla
 *
 */
@ComponentScan
@Component
@Configuration
@EnableCouchbaseRepositories(basePackages="com.vrk.couchbase.repo")
public abstract class CouchBaseConfig extends AbstractCouchbaseConfiguration{

	@Value("${hostname}")
	private static String hostname;

	@Value("${empbucket.name}")
	private static String empBucket;

	@Value("${empbucket.password}")
	private static String empPassword;

	public @Bean Cluster cluster() {
		return CouchbaseCluster.create(hostname);
	}
	
	 public @Bean Bucket employeeBucket() {
	        return cluster().openBucket(empBucket, empPassword);
	    }
	
	 
	@Bean
	  public CouchbaseTemplate empTemplate() throws Exception {
	    CouchbaseTemplate template = new CouchbaseTemplate(couchbaseClusterInfo(), employeeBucket(), mappingCouchbaseConverter(), translationService());
	    template.setDefaultConsistency(getDefaultConsistency());
	    return template;
	  }
	
	@Bean
	public void configureRepositoryOperationsMapping(RepositoryOperationsMapping baseMapping) {
	    try {
			baseMapping.mapEntity(Employee.class, empTemplate());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	  }

}
