package cn.cupbread.glanzz.Service;

import ch.qos.logback.core.util.TimeUtil;
import cn.cupbread.glanzz.DAO.TokenRepository;
import cn.cupbread.glanzz.Entity.Token;
import cn.hutool.Hutool;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Date: 2020/2/22
 * @Author: CupOfBread
 * @Description:
 */
@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private TokenRepository tokenRepository;

    @Transactional
    @Override
    public Token create_token(String mail) {
        Token token=tokenRepository.findByMail(mail);
        if (token==null){
            token=new Token().setMail(mail).setToken(IdUtil.simpleUUID());
        }
        token.setCreateTime(DateUtil.now());
        token.setExpTime(DateUtil.formatDateTime(DateUtil.offsetDay(DateUtil.date(new Date()),3)));
        return tokenRepository.save(token);
    }

    @Transactional
    @Override
    public Token check_token(String token) {
        Token token1=tokenRepository.findByToken(token);
        if (token1==null) return null;
        Date nowTime=new Date();
        Date tokenExpTime=DateUtil.parse(token1.getExpTime());
        if (nowTime.getTime()>tokenExpTime.getTime()) return null;
        return token1;
    }
}
