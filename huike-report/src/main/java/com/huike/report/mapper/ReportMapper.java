package com.huike.report.mapper;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import com.huike.report.domain.vo.BusinessChangeStatisticsVo;
import com.huike.report.domain.vo.CourseNumVO;
import org.apache.ibatis.annotations.Param;

import com.huike.clues.domain.vo.IndexStatisticsVo;

/**
 * 首页统计分析的Mapper
 * @author Administrator
 *
 */
public interface ReportMapper {
	/**=========================================基本数据========================================*/
	/**
	 * 获取线索数量
	 * @param beginCreateTime	开始时间
	 * @param endCreateTime		结束时间
	 * @param username			用户名
	 * @return
	 */
	Integer getCluesNum(@Param("startTime") String beginCreateTime,
						@Param("endTime") String endCreateTime,
						@Param("username") String username);

	/**
	 * 获取商机数量
	 * @param beginCreateTime	开始时间
	 * @param endCreateTime		结束时间
	 * @param username			用户名
	 * @return
	 */
	Integer getBusinessNum(@Param("startTime") String beginCreateTime,
						   @Param("endTime") String endCreateTime,
						   @Param("username") String username);

	/**
	 * 获取合同数量
	 * @param beginCreateTime	开始时间
	 * @param endCreateTime		结束时间
	 * @param username			用户名
	 * @return
	 */
	Integer getContractNum(@Param("startTime") String beginCreateTime,
						   @Param("endTime") String endCreateTime,
						   @Param("username") String username);

	/**
	 * 获取合同金额
	 * @param beginCreateTime	开始时间
	 * @param endCreateTime		结束时间
	 * @param username			用户名
	 * @return
	 */
	Double getSalesAmount(@Param("startTime") String beginCreateTime,
						  @Param("endTime") String endCreateTime,
						  @Param("username") String username);


	/**=========================================今日简报========================================*/
	Integer getCluesCountByNowDate(@Param("startTime") String beginCreateTime,
								   @Param("endTime") String endCreateTime,
								   @Param("username") String username);

	Integer getBusinessCountByNowDate(@Param("startTime") String beginCreateTime,
									  @Param("endTime") String endCreateTime,
									  @Param("username") String username);

	Integer getContractCountByNowDate(@Param("startTime") String beginCreateTime,
									  @Param("endTime") String endCreateTime,
									  @Param("username") String username);

	Double getSalesAmountByNowDate(@Param("startTime") String beginCreateTime,
									@Param("endTime") String endCreateTime,
								   @Param("username") String username);

	/**=========================================待办========================================*/

	Integer getNoCluesReport(@Param("startTime") String beginCreateTime,
						@Param("endTime") String endCreateTime);

	Integer getNoBusinessReport(@Param("startTime") String beginCreateTime,
								@Param("endTime") String endCreateTime);

	//学科数量
    List<CourseNumVO> courseStatistics(@Param("startTime") String beginCreateTime,
									   @Param("endTime") String endCreateTime);
	//查询所有线索
	Integer getCluesAll(@Param("startTime") String beginCreateTime,
						@Param("endTime") String endCreateTime);

	Integer getEffectiveCluesNums(@Param("startTime") String beginCreateTime,
								  @Param("endTime") String endCreateTime);

	Integer getReportBusinessNums(@Param("startTime") String beginCreateTime,
								  @Param("endTime") String endCreateTime);

	Integer getReportContractNums(@Param("startTime") String beginCreateTime,
								  @Param("endTime") String endCreateTime);

	List<BusinessChangeStatisticsVo> getsalesStatistic(@Param("startTime") String beginCreateTime,
																 @Param("endTime") String endCreateTime);

	List<BusinessChangeStatisticsVo> getCluesNumByNmaes(@Param("startTime") String beginCreateTime,
														@Param("endTime") String endCreateTime);

	List<BusinessChangeStatisticsVo> getBusinessChangeStatistics(@Param("startTime") String beginCreateTime,
																 @Param("endTime") String endCreateTime);

	Integer getBusiness(@Param("startTime") String beginCreateTime,
						@Param("endTime") String endCreateTime);

}
