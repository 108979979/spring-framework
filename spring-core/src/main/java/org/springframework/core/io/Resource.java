/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

/**
 * Interface for a resource descriptor that abstracts from the actual
 * type of underlying resource, such as a file or class path resource.
 *
 * <p>An InputStream can be opened for every resource if it exists in
 * physical form, but a URL or File handle can just be returned for
 * certain resources. The actual behavior is implementation-specific.
 *
 * @author Juergen Hoeller
 * @since 28.12.2003
 * @see #getInputStream()
 * @see #getURL()
 * @see #getURI()
 * @see #getFile()
 * @see WritableResource
 * @see ContextResource
 * @see UrlResource
 * @see ClassPathResource
 * @see FileSystemResource
 * @see PathResource
 * @see ByteArrayResource
 * @see InputStreamResource
 */
public interface Resource extends InputStreamSource {

	/**
     * 资源是否存在
     */
	boolean exists();

	/**
     * 资源是否可读
     */
	boolean isReadable();

	/**
     * 资源所代表的句柄是否被一个stream打开了
     */
	boolean isOpen();

	/**
     * 返回资源的URL的句柄
     */
	URL getURL() throws IOException;

	/**
     * 返回资源的URI的句柄
     */
	URI getURI() throws IOException;

	/**
     * 返回资源的File的句柄
     */
	File getFile() throws IOException;

	/**
     * 资源内容的长度
     */
	long contentLength() throws IOException;

	/**
     * 资源最后的修改时间
     */
	long lastModified() throws IOException;

	/**
     * 根据资源的相对路径创建新资源
     */
	Resource createRelative(String relativePath) throws IOException;

	/**
     * 资源的文件名
     */
	String getFilename();

	/**
     * 资源的描述
     */
	String getDescription();

}
