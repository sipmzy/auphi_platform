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
package com.auphi.data.hub.controller;

import com.auphi.data.hub.core.BaseMultiActionController;
import com.auphi.data.hub.core.PaginationSupport;
import com.auphi.data.hub.core.struct.BaseDto;
import com.auphi.data.hub.core.struct.Dto;
import com.auphi.data.hub.core.util.JsonHelper;
import com.auphi.data.hub.service.DataExportIncrementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

/**
 * 数据集市Oracle数据增量抽取控制器
 * 
 * @author anx
 *
 */
@Controller("dataexportincrement")
public class DataExportIncrementController extends BaseMultiActionController {

	private final static String INDEX = "admin/exportIncrement";
	
	@Autowired
	private DataExportIncrementService exportIncrementService;
	
	public ModelAndView index(HttpServletRequest req,HttpServletResponse resp){
		return new ModelAndView(INDEX);
	}
	
	public ModelAndView list(HttpServletRequest req,HttpServletResponse resp){
		Dto<String,Object> dto = new BaseDto();
		try {
			this.setPageParam(dto, req);
			PaginationSupport<Dto<String, Object>> page = exportIncrementService.queryExportIncrement(dto);
			String jsonString = JsonHelper.encodeObject2Json(page,"yyyy-MM-dd HH:mm:ss");
			write(jsonString, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ModelAndView save(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		Map<String, Object> params = WebUtils.getParametersStartingWith(req, "p_");
		try{
			exportIncrementService.saveExportIncrement(params);
			setOkTipMsg("新增数据导出任务增量导出入库成功", resp);
		} catch(Exception e){
			e.printStackTrace();
			setFailTipMsg("新增数据导出任务增量导出入库失败", resp);
		}
		
		return null;
	}
	
	public ModelAndView update(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		Map<String, Object> params = WebUtils.getParametersStartingWith(req, "p_");
		exportIncrementService.updateExportIncrement(params);
		setOkTipMsg("修改数据导出任务配置成功", resp);
		return null;
	}
	
	public ModelAndView delete(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String strChecked = req.getParameter("strChecked");
		Dto inDto = new BaseDto();
		inDto.put("strChecked", strChecked);
		exportIncrementService.deleteExportIncrement(inDto);
		setOkTipMsg("数据导出任务配置删除成功", resp);
		return null;
	}
	
}
