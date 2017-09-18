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
package com.auphi.ktrl.mdm.domain;import java.util.ArrayList;import java.util.List;import com.sun.swing.internal.plaf.basic.resources.basic;/**    * This class is used for ...    * @author Tony  * @version    *       1.0, 2016-2-25 下午4:59:39    */public class MdmMapingTable {		private Integer id_model; //数据模型	private String attribute_model;//模型属性	private Integer mdm_id_database;//主数据表-数据源id	private String mdm_schema_name;//主数据表-模式名	private String mdm_table_name;//主数据表-表名	private String mdm_primary_key;//主数据表-主键字段	private String mdm_column_name ;//主数据表-名称字段		private String original_key;//原主键	private String original_name;//原值	private String standard_key;//标准主键	private String standard_name;//标准值	private List<MdmMapingResult> successes; //返回结果		private List<MdmMapingResult> failures; //返回结果		public boolean isOne(MdmDataClean mdmDataClean){		if(mdmDataClean == null){			return false;		}		boolean a = mdmDataClean.getId_model() == this.id_model;		boolean b = mdmDataClean.getAttribute_model().equals(this.attribute_model);		boolean c = (mdmDataClean.getMdm_schema_name() == null && this.mdm_schema_name == null) || (mdmDataClean.getMdm_schema_name()!=null && mdmDataClean.getMdm_schema_name().equals(this.mdm_schema_name));		boolean d = mdmDataClean.getMdm_table_name().equals(this.mdm_table_name);		boolean e = mdmDataClean.getMdm_primary_key().equals(this.mdm_primary_key);		boolean f = mdmDataClean.getMdm_column_name().equals(this.mdm_column_name);		boolean g = mdmDataClean.getMdm_id_database() == this.mdm_id_database;				if(a && b && c && d && e && f && g){			return true;		}				return false;			}			public String getOriginal_key() {		return original_key;	}	public void setOriginal_key(String original_key) {		this.original_key = original_key;	}	public String getOriginal_name() {		return original_name;	}	public void setOriginal_name(String original_name) {		this.original_name = original_name;	}	public String getStandard_key() {		return standard_key;	}	public void setStandard_key(String standard_key) {		this.standard_key = standard_key;	}	public String getStandard_name() {		return standard_name;	}	public void setStandard_name(String standard_name) {		this.standard_name = standard_name;	}	public List<MdmMapingResult> getSuccesses() {		if(successes == null){			successes = new ArrayList<MdmMapingResult>();		}		return successes;	}	public void setSuccesses(List<MdmMapingResult> successes) {		this.successes = successes;	}	public List<MdmMapingResult> getFailures() {		if(failures == null){			failures = new ArrayList<MdmMapingResult>();		}		return failures;	}	public void setFailures(List<MdmMapingResult> failures) {		this.failures = failures;	}	public Integer getId_model() {		return id_model;	}	public void setId_model(Integer id_model) {		this.id_model = id_model;	}	public String getAttribute_model() {		return attribute_model;	}	public void setAttribute_model(String attribute_model) {		this.attribute_model = attribute_model;	}	public Integer getMdm_id_database() {		return mdm_id_database;	}	public void setMdm_id_database(Integer mdm_id_database) {		this.mdm_id_database = mdm_id_database;	}	public String getMdm_schema_name() {		return mdm_schema_name;	}	public void setMdm_schema_name(String mdm_schema_name) {		this.mdm_schema_name = mdm_schema_name;	}	public String getMdm_table_name() {		return mdm_table_name;	}	public void setMdm_table_name(String mdm_table_name) {		this.mdm_table_name = mdm_table_name;	}	public String getMdm_primary_key() {		return mdm_primary_key;	}	public void setMdm_primary_key(String mdm_primary_key) {		this.mdm_primary_key = mdm_primary_key;	}	public String getMdm_column_name() {		return mdm_column_name;	}	public void setMdm_column_name(String mdm_column_name) {		this.mdm_column_name = mdm_column_name;	}		}