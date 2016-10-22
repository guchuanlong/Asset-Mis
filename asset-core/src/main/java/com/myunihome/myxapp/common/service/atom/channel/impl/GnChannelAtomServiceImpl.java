package com.myunihome.myxapp.common.service.atom.channel.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.common.api.channel.param.ChlQueryCond;
import com.myunihome.myxapp.common.dao.mapper.bo.GnChannel;
import com.myunihome.myxapp.common.dao.mapper.bo.GnChannelCriteria;
import com.myunihome.myxapp.common.dao.mapper.interfaces.GnChannelMapper;
import com.myunihome.myxapp.common.service.atom.channel.IGnChannelAtomService;
import com.myunihome.myxapp.paas.util.CollectionUtil;
import com.myunihome.myxapp.paas.util.StringUtil;
import com.myunihome.myxapp.sso.dao.mapper.factory.MapperFactory;

@Component
public class GnChannelAtomServiceImpl implements IGnChannelAtomService {

    @Override
    public List<GnChannel> searchChildrenChannel(String tenantId,String departId, String channelId) {
        GnChannelCriteria gnChannelCriteria = new GnChannelCriteria();
        GnChannelCriteria.Criteria criteria = new GnChannelCriteria().createCriteria();
        if (!StringUtils.isEmpty(departId)) {
            criteria.andStateEqualTo("1");
            criteria.andDepartIdEqualTo(departId);
            criteria.andTenantIdEqualTo(tenantId);
        }

        GnChannelCriteria.Criteria orCriteria = new GnChannelCriteria().createCriteria();
        if (!StringUtils.isEmpty(channelId)) {
            orCriteria.andStateEqualTo("1");
            orCriteria.andSuperChnlIdEqualTo(channelId);
            orCriteria.andTenantIdEqualTo(tenantId);
        }
        gnChannelCriteria.or(criteria);
        gnChannelCriteria.or(orCriteria);
        return MapperFactory.getGnChannelMapper().selectByExample(gnChannelCriteria);
    }

    @Override
    public GnChannel selectChannelById(String tenantId,String channelID) {
        GnChannelCriteria gnChannelCriteria = new GnChannelCriteria();
        gnChannelCriteria.createCriteria().andStateEqualTo("1").andChnlIdEqualTo(channelID).andTenantIdEqualTo(tenantId);
        List<GnChannel> gnChannels = MapperFactory.getGnChannelMapper().selectByExample(gnChannelCriteria);
        if (CollectionUtil.isEmpty(gnChannels)){
            return null;
        }
        return gnChannels.get(0);
    }

	@Override
	public PageInfo<GnChannel> queryChannelsByPage(ChlQueryCond cond) {
		GnChannelCriteria sql = new GnChannelCriteria();
		GnChannelCriteria.Criteria criteria = sql.or().andTenantIdEqualTo(cond.getTenantId());
		if(!StringUtil.isBlank(cond.getChnlId())){
			criteria.andChnlIdEqualTo(cond.getChnlId());
		}
        if(!StringUtil.isBlank(cond.getChnlCode())){
            criteria.andChnlCodeEqualTo(cond.getChnlCode());
        }
        if(!StringUtil.isBlank(cond.getChnlName())){
            criteria.andChnlNameEqualTo(cond.getChnlName()); 
        }
        if(!StringUtil.isBlank(cond.getCityCode())){
            criteria.andCityCodeEqualTo(cond.getCityCode()); 
        }
        if(!StringUtil.isBlank(cond.getProvinceCode())){
            criteria.andProvinceCodeEqualTo(cond.getProvinceCode()); 
        }
        if(!StringUtil.isBlank(cond.getKindId())){
            criteria.andChnlKindIdEqualTo(cond.getKindId()); 
        }
        
        PageInfo<GnChannel> pageInfo = new PageInfo<GnChannel>();
        GnChannelMapper idxMapper = MapperFactory.getGnChannelMapper();
        pageInfo.setCount(idxMapper.countByExample(sql));
        if(cond.getPageInfo()!=null){
        	 sql.setLimitStart(cond.getPageInfo().getStartRowIndex()-1);
             sql.setLimitEnd(cond.getPageInfo().getPageSize());
             pageInfo.setPageNo(cond.getPageInfo().getPageNo());
             pageInfo.setPageSize(cond.getPageInfo().getPageSize());
        }
        else{
        	pageInfo.setPageNo(1);
            pageInfo.setPageSize(pageInfo.getCount()==0?10:pageInfo.getCount());
        }
        pageInfo.setResult(idxMapper.selectByExample(sql));
        return pageInfo;
	}
}
