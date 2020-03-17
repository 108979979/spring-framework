/*
 * Copyright 2002-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package test.resource.loader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * 
 * @author win10
 * @since 4.2.1
 */
public class ResourceLoaderTest {

	/**
	 * DefaultResourceLoader
	 */
	@Test
	public void testDefaultResourceLoader() throws IOException {
		ResourceLoader resourceLoader = new DefaultResourceLoader();

		Resource fileResource1 = resourceLoader.getResource("D:/Users/chenming673/Documents/spark.txt");
		System.out.println("fileResource1 is FileSystemResource:"+ (fileResource1 instanceof FileSystemResource));
		System.out.println("fileResource1 is FileSystemResource:"+ (fileResource1 instanceof ClassPathResource));

		Resource fileResource2 = resourceLoader.getResource("/Users/chenming673/Documents/spark.txt");
		System.out.println("fileResource2 is ClassPathResource:"+ (fileResource2 instanceof ClassPathResource));

		Resource urlResource1 = resourceLoader.getResource("file:/Users/chenming673/Documents/spark.txt");
		System.out.println("urlResource1 is UrlResource:" + (urlResource1 instanceof UrlResource));

		Resource urlResource2 = resourceLoader.getResource("http://www.baidu.com");
		System.out.println("urlResource1 is urlResource:" + (urlResource2 instanceof UrlResource));
		
		Resource urlResource3 = resourceLoader.getResource("WEB-INF/test.dat");
		System.out.println("urlResource3 is ClassPathContextResource:" + (urlResource3 instanceof ClassPathResource));
	}
	
	@Test
	public void testFileSystemResourceLoader() throws IOException {
		System.out.println("======testFileSystemResourceLoader======");
		ResourceLoader resourceLoader = new FileSystemResourceLoader();
		
		Resource fileResource1 = resourceLoader.getResource("D:/Users/chenming673/Documents/spark.txt");
		System.out.println("fileResource1 is FileSystemResource:"+ (fileResource1 instanceof FileSystemResource));
		System.out.println("fileResource1 is ClassPathResource:"+ (fileResource1 instanceof ClassPathResource));
		
		Resource fileResource2 = resourceLoader.getResource("/Users/chenming673/Documents/spark.txt");
		System.out.println("fileResource2 is ClassPathResource:"+ (fileResource2 instanceof ClassPathResource));
		
		Resource urlResource1 = resourceLoader.getResource("file:/Users/chenming673/Documents/spark.txt");
		System.out.println("urlResource1 is UrlResource:" + (urlResource1 instanceof UrlResource));
		
		Resource urlResource2 = resourceLoader.getResource("http://www.baidu.com");
		System.out.println("urlResource1 is urlResource:" + (urlResource2 instanceof UrlResource));
	}
	
	/**
	 * 通配符
	 */
	@Test
	public void testPathMatchingResourcePatternResolver() throws IOException {
		System.out.println("======testPathMatchingResourcePatternResolver======");
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		
		Resource[] resources = resolver.getResources("classpath*:test/resource/loader");
		
		System.out.println(resources.length);
	}
	
	
	
	
	

}
