package jp.co.internous.rainbow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.rainbow.model.mapper.MstProductMapper;
import jp.co.internous.rainbow.model.session.LoginSession;
import jp.co.internous.rainbow.model.domain.MstProduct;

@Controller
@RequestMapping("/rainbow/product")
public class ProductController {

	@Autowired
	private MstProductMapper productMapper;

	@Autowired
	private LoginSession loginSession;

	/**
	 * @param id
	 * @param m  画面に渡すデータ
	 * @return "product_detail"に遷移
	 */
	@RequestMapping("/{id}")
	public String index(@PathVariable("id") int id, Model m) {
		// 商品情報を取得
		MstProduct product = productMapper.findById(id);
		m.addAttribute("product", product);
		// page_header.htmlでsessionの変数を表示させているため、loginSessionも画面に送る。
		m.addAttribute("loginSession", loginSession);

		return "product_detail";
	}
}
