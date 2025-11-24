package com.ig.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.ig.entity.EmpEntity;
import com.ig.model.EmpVO;
import com.ig.repo.IEmpRepo;

@Service
public class EmpService 
{
	@Autowired
	public IEmpRepo repo;
	
	public Page<EmpVO> findAll(Pageable pageable)
	{
		 List<EmpVO> volist = new ArrayList<EmpVO>();
		 Page<EmpEntity> pageEntity = repo.findAll(pageable);
		 pageEntity.getContent().forEach(entity->{
			 EmpVO vo = new EmpVO();
			 BeanUtils.copyProperties(entity,vo);
			 volist.add(vo);
		 });
		 Page<EmpVO> pageVo = new PageImpl<EmpVO>(volist, pageable, repo.count());
		 
		 return pageVo; 
	}
	
	public EmpEntity findById(Integer id)
	{
		 EmpEntity entity =  repo.findById(id).orElseThrow(
				 ()->new IllegalArgumentException("invalid id")
				 );
		 return entity;
	}
	
	public EmpVO findVOById(Integer id)
	{
		 EmpVO vo = new EmpVO();
		 EmpEntity entity =  repo.findById(id).orElseThrow(
				 ()->new IllegalArgumentException("invalid id")
				 );
		 BeanUtils.copyProperties(entity, vo);
		 return vo;
	}
	
	public List<EmpVO> findAll()
	{
		 List<EmpVO> volist = new ArrayList<EmpVO>();
		 Iterable<EmpEntity> list = repo.findAll();
		 list.forEach(e->{
			 EmpVO vo = new EmpVO();
			 BeanUtils.copyProperties(e, vo);
			 volist.add(vo);
		 });
		 return volist;
	}
	
	public String save(EmpVO vo)
	{
		 EmpEntity entity = new EmpEntity();
		 BeanUtils.copyProperties(vo, entity);
		 EmpEntity saved  = repo.save(entity);
		 return "Employee[id="+saved.getId()+",name="+saved.getName()+"] saved in DB";
	}
	
	public String edit(EmpVO vo)
	{
		 EmpEntity entity = findById(vo.getId());
		 BeanUtils.copyProperties(vo, entity);
		 EmpEntity saved  = repo.save(entity);
		 return "Employee[id="+saved.getId()+",name="+saved.getName()+"] updated in DB";
	}
	
	public String delete(Integer id)
	{
		 EmpEntity entity = findById(id);
		 repo.delete(entity);
		 return "Employee[id="+entity.getId()+",name="+entity.getName()+"] deleted in DB";
	}
}
