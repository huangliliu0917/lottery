package me.zohar.dict;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import me.zohar.lottery.common.utils.IdUtils;
import me.zohar.lottery.dictconfig.domain.DictItem;
import me.zohar.lottery.dictconfig.domain.DictType;
import me.zohar.lottery.dictconfig.repo.DictItemRepo;
import me.zohar.lottery.dictconfig.repo.DictTypeRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DictTest {

	@Autowired
	private DictTypeRepo dictTypeRepo;

	@Autowired
	private DictItemRepo dictItemRepo;

	public DictItem buildDictItem(String dictItemCode, String dictItemName, Double orderNo, String dictTypeId) {
		DictItem dictItem = new DictItem();
		dictItem.setId(IdUtils.getId());
		dictItem.setDictItemCode(dictItemCode);
		dictItem.setDictItemName(dictItemName);
		dictItem.setOrderNo(orderNo);
		dictItem.setDictTypeId(dictTypeId);
		return dictItem;
	}
	
	/**
	 * 初始化游戏玩法状态字典
	 */
	@Test
	@Transactional(readOnly = false)
	@Rollback(false)
	public void initGamePlayStateDict() {
		DictType dictType = new DictType();
		dictType.setId(IdUtils.getId());
		dictType.setDictTypeCode("gamePlayState");
		dictType.setDictTypeName("玩法状态");
		dictTypeRepo.save(dictType);

		dictItemRepo.save(buildDictItem("1", "启用", 1d, dictType.getId()));
		dictItemRepo.save(buildDictItem("0", "禁用", 2d, dictType.getId()));
	}

	/**
	 * 初始化游戏状态字典
	 */
	@Test
	@Transactional(readOnly = false)
	@Rollback(false)
	public void initGameStateDict() {
		DictType dictType = new DictType();
		dictType.setId(IdUtils.getId());
		dictType.setDictTypeCode("gameState");
		dictType.setDictTypeName("游戏状态");
		dictTypeRepo.save(dictType);

		dictItemRepo.save(buildDictItem("1", "启用", 1d, dictType.getId()));
		dictItemRepo.save(buildDictItem("2", "禁用", 2d, dictType.getId()));
		dictItemRepo.save(buildDictItem("3", "维护中", 3d, dictType.getId()));
	}

	/**
	 * 充提日志订单类型字典
	 */
	@Test
	@Transactional(readOnly = false)
	@Rollback(false)
	public void initRechargeWithdrawLogOrderTypeDict() {
		DictType dictType = new DictType();
		dictType.setId(IdUtils.getId());
		dictType.setDictTypeCode("rechargeWithdrawLogOrderType");
		dictType.setDictTypeName("充值日志订单类型");
		dictTypeRepo.save(dictType);

		dictItemRepo.save(buildDictItem("1", "充值", 1d, dictType.getId()));
		dictItemRepo.save(buildDictItem("2", "提现", 1d, dictType.getId()));
	}

	/**
	 * 初始化充值订单状态字典
	 */
	@Test
	@Transactional(readOnly = false)
	@Rollback(false)
	public void initRechargeOrderStateDict() {
		DictType dictType = new DictType();
		dictType.setId(IdUtils.getId());
		dictType.setDictTypeCode("rechargeOrderState");
		dictType.setDictTypeName("充值订单状态");
		dictTypeRepo.save(dictType);

		dictItemRepo.save(buildDictItem("1", "待支付", 1d, dictType.getId()));
		dictItemRepo.save(buildDictItem("2", "已支付", 1d, dictType.getId()));
		dictItemRepo.save(buildDictItem("3", "超时取消", 1d, dictType.getId()));
	}

	/**
	 * 初始化投注订单状态字典
	 */
	@Test
	@Transactional(readOnly = false)
	@Rollback(false)
	public void initbettingOrderStateDict() {
		DictType dictType = new DictType();
		dictType.setId(IdUtils.getId());
		dictType.setDictTypeCode("bettingOrderState");
		dictType.setDictTypeName("投注订单状态");
		dictTypeRepo.save(dictType);

		dictItemRepo.save(buildDictItem("1", "未开奖", 1d, dictType.getId()));
		dictItemRepo.save(buildDictItem("2", "未中奖", 2d, dictType.getId()));
		dictItemRepo.save(buildDictItem("3", "已中奖", 3d, dictType.getId()));
	}

	/**
	 * 初始化游戏字典
	 */
	@Test
	@Transactional(readOnly = false)
	@Rollback(false)
	public void initGameDict() {
		DictType dictType = new DictType();
		dictType.setId(IdUtils.getId());
		dictType.setDictTypeCode("game");
		dictType.setDictTypeName("游戏");
		dictTypeRepo.save(dictType);

		dictItemRepo.save(buildDictItem("CQSSC", "重庆时时彩", 1d, dictType.getId()));
	}

	/**
	 * 初始化账变类型字典
	 */
	@Test
	@Transactional(readOnly = false)
	@Rollback(false)
	public void initAccountChangeTypeDict() {
		DictType dictType = new DictType();
		dictType.setId(IdUtils.getId());
		dictType.setDictTypeCode("accountChangeType");
		dictType.setDictTypeName("账变类型");
		dictTypeRepo.save(dictType);

		dictItemRepo.save(buildDictItem("1", "账号充值", 1d, dictType.getId()));
		dictItemRepo.save(buildDictItem("2", "充值优惠", 2d, dictType.getId()));
		dictItemRepo.save(buildDictItem("3", "投注扣款", 3d, dictType.getId()));
		dictItemRepo.save(buildDictItem("4", "投注返奖", 4d, dictType.getId()));

	}

}