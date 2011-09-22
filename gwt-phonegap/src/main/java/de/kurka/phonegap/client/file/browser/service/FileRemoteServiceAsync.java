/*
 * Copyright 2010 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package de.kurka.phonegap.client.file.browser.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.kurka.phonegap.client.file.browser.dto.FileSystemDTO;
import de.kurka.phonegap.client.file.browser.dto.FileSystemEntryDTO;
import de.kurka.phonegap.client.file.browser.dto.FileWriterDTO;
import de.kurka.phonegap.client.file.browser.dto.FlagsDTO;
import de.kurka.phonegap.client.file.browser.dto.MetaDataDTO;

public interface FileRemoteServiceAsync {

	void requestFileSystem(int fileSystemType, int size, AsyncCallback<FileSystemDTO> callback);

	void readDirectory(String path, AsyncCallback<ArrayList<FileSystemEntryDTO>> callback);

	/**
	 * @param fullPath
	 */
	void getParent(String fullPath, AsyncCallback<FileSystemEntryDTO> callback);

	/**
	 * @param fullPath
	 * @param callback
	 */
	void readAsText(String fullPath, AsyncCallback<String> callback);

	void createWriter(String fullPath, String name, AsyncCallback<FileWriterDTO> asyncCallback);

	void writeFile(FileWriterDTO fileWriterDTO, String content, AsyncCallback<FileWriterDTO> callback);

	void getMetaData(String fullPath, AsyncCallback<MetaDataDTO> callback);

	/**
	 * @param absPath
	 * @param flagsDTO
	 * @param asyncCallback
	 */
	void getFile(String absPath, FlagsDTO flagsDTO, AsyncCallback<FileSystemEntryDTO> callback);

}