package com.my.smnb20_2.Dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.my.smnb20_2.service.*;
//import com.my.smnb20_2.Domain.BidxSearchCriteria;
import com.my.smnb20_2.Domain.BoardVO;
import com.my.smnb20_2.Domain.Criteria;
import com.my.smnb20_2.Domain.MemberVO;
import com.my.smnb20_2.Domain.SearchCriteria;
import com.my.smnb20_2.Domain.PageMaker;
import com.my.smnb20_2.service.*;



public interface MemberDAO_Father_Mapper {
  
	public MemberVO loginCheck(MemberVO mv);

}

