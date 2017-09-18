/*******************************************************************************
 *
 * Auphi Data Integration PlatformKettle Platform
 * Copyright C 2011-2017 by Auphi BI : http://www.doetl.com 

 * Support：support@pentahochina.com
 *
 *******************************************************************************
 *
 * Licensed under the LGPL License, Version 3.0 the "License";
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    https://opensource.org/licenses/LGPL-3.0 

 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/
package com.auphi.data.hub.service;



import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.auphi.data.hub.core.PaginationSupport;
import com.auphi.data.hub.core.struct.Dto;
import com.auphi.data.hub.domain.Datasource;


/**
 * 任务业务接口 
 * 
 * @author zhangjf
 *
 */
public interface DatasourceService {
	
	public PaginationSupport<Datasource> queryDatasourceList(Dto dto)throws SQLException;
	
	
	public void saveDatasource(Datasource source);
	
	public void updateDatasource(Datasource source);
	
	public void deleteDatasource(Map<String,Object> params);
	
	public List<Datasource> querySourceList();

}
