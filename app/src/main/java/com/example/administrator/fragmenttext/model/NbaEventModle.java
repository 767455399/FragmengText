package com.example.administrator.fragmenttext.model;

import java.util.List;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/28 17:25
 * 修改人：WangQing
 * 修改时间：2016/1/28 17:25
 * 修改备注：
 */
public class NbaEventModle {

    /**
     * title : NBA2015-2016赛季_常规赛视频直播_腾讯体育
     * statuslist : {"st0":"未开赛","st1":"直播中","st2":"已结束"}
     * list : [{"title":"01-27 周三","tr":[{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/e/eog3ek4qla1w56x.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468172","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468172%26title%3D%25E5%25BF%25AB%25E8%2588%25B9VS%25E6%25AD%25A5%25E8%25A1%258C%25E8%2580%2585%26ptag%3D360.onebox.schedule.nba&m=c81cb4&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468172%26title%3D%25E5%25BF%25AB%25E8%2588%25B9VS%25E6%25AD%25A5%25E8%25A1%258C%25E8%2580%2585%26ptag%3D360.onebox.schedule.nba&m=c81cb4&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"快船","player1logo":"http://p2.qhimg.com/t01d220267d6bb70361.png","player1logobig":"http://p2.qhimg.com/t01d220267d6bb70361.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=12","player2":"步行者","player2logo":"http://p3.qhimg.com/t01a540cb8f7dae8bd7.png","player2logobig":"http://p3.qhimg.com/t01a540cb8f7dae8bd7.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=11","score":"91-89","status":"2","time":"01/27 08:00"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/y/y1nh43yjact7pdi.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468173","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468173%26title%3D%25E5%25A4%25AA%25E9%2598%25B3VS76%25E4%25BA%25BA%26ptag%3D360.onebox.schedule.nba&m=341e74&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468173%26title%3D%25E5%25A4%25AA%25E9%2598%25B3VS76%25E4%25BA%25BA%26ptag%3D360.onebox.schedule.nba&m=341e74&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"太阳","player1logo":"http://p8.qhimg.com/t01b949ab71ba5b6da6.png","player1logobig":"http://p8.qhimg.com/t01b949ab71ba5b6da6.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=21","player2":"76人","player2logo":"http://p8.qhimg.com/t011e23b36ad399a0d1.png","player2logobig":"http://p8.qhimg.com/t011e23b36ad399a0d1.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=20","score":"103-113","status":"2","time":"01/27 08:00"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/b/ba2zi8qztpxrvyf.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468174","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468174%26title%3D%25E7%2583%25AD%25E7%2581%25ABVS%25E7%25AF%25AE%25E7%25BD%2591%26ptag%3D360.onebox.schedule.nba&m=990b59&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468174%26title%3D%25E7%2583%25AD%25E7%2581%25ABVS%25E7%25AF%25AE%25E7%25BD%2591%26ptag%3D360.onebox.schedule.nba&m=990b59&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"热火","player1logo":"http://p7.qhimg.com/t011bd398c0da29c27d.png","player1logobig":"http://p7.qhimg.com/t011bd398c0da29c27d.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=14","player2":"篮网","player2logo":"http://p7.qhimg.com/t01642d73a8ebb2f3b6.png","player2logobig":"http://p7.qhimg.com/t01642d73a8ebb2f3b6.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=17","score":"102-98","status":"2","time":"01/27 08:30"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/u/u3se8angql4b02v.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468175","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468175%26title%3D%25E9%259B%25B7%25E9%259C%2586VS%25E5%25B0%25BC%25E5%2585%258B%25E6%2596%25AF%26ptag%3D360.onebox.schedule.nba&m=a165b4&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468175%26title%3D%25E9%259B%25B7%25E9%259C%2586VS%25E5%25B0%25BC%25E5%2585%258B%25E6%2596%25AF%26ptag%3D360.onebox.schedule.nba&m=a165b4&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"雷霆","player1logo":"http://p8.qhimg.com/t0198101dee56f2e9e6.png","player1logobig":"http://p8.qhimg.com/t0198101dee56f2e9e6.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=25","player2":"尼克斯","player2logo":"http://p2.qhimg.com/t01eb9fe49a7bfa9614.png","player2logobig":"http://p2.qhimg.com/t01eb9fe49a7bfa9614.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=18","score":"128-122","status":"2","time":"01/27 08:30"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/3/34c7fs4urb56lu2.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468176","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468176%26title%3D%25E5%25A5%2587%25E6%2589%258DVS%25E7%258C%259B%25E9%25BE%2599%26ptag%3D360.onebox.schedule.nba&m=9821b9&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468176%26title%3D%25E5%25A5%2587%25E6%2589%258DVS%25E7%258C%259B%25E9%25BE%2599%26ptag%3D360.onebox.schedule.nba&m=9821b9&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"奇才","player1logo":"http://p9.qhimg.com/t0186052b1961c20365.png","player1logobig":"http://p9.qhimg.com/t0186052b1961c20365.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=27","player2":"猛龙","player2logo":"http://p6.qhimg.com/t017cc5b5930e09f481.png","player2logobig":"http://p6.qhimg.com/t017cc5b5930e09f481.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=28","score":"89-106","status":"2","time":"01/27 08:30"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/f/fwzmrv5dxp2qbgn.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468177","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468177%26title%3D%25E9%25AD%2594%25E6%259C%25AFVS%25E9%259B%2584%25E9%25B9%25BF%26ptag%3D360.onebox.schedule.nba&m=1fd38d&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468177%26title%3D%25E9%25AD%2594%25E6%259C%25AFVS%25E9%259B%2584%25E9%25B9%25BF%26ptag%3D360.onebox.schedule.nba&m=1fd38d&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"魔术","player1logo":"http://p6.qhimg.com/t015a91103bd3713d72.png","player1logobig":"http://p6.qhimg.com/t015a91103bd3713d72.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=19","player2":"雄鹿","player2logo":"http://p7.qhimg.com/t0159c5c7fc7989e826.png","player2logobig":"http://p7.qhimg.com/t0159c5c7fc7989e826.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=15","score":"100-107","status":"2","time":"01/27 09:00"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/x/xixqssx0jpr5sa0.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468178","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468178%26title%3D%25E5%259B%25BD%25E7%258E%258BVS%25E5%25BC%2580%25E6%258B%2593%25E8%2580%2585%26ptag%3D360.onebox.schedule.nba&m=b8303f&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468178%26title%3D%25E5%259B%25BD%25E7%258E%258BVS%25E5%25BC%2580%25E6%258B%2593%25E8%2580%2585%26ptag%3D360.onebox.schedule.nba&m=b8303f&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"国王","player1logo":"http://p2.qhimg.com/t0179411022c3587ba2.png","player1logobig":"http://p2.qhimg.com/t0179411022c3587ba2.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=23","player2":"开拓者","player2logo":"http://p8.qhimg.com/t01fdabb4fd4f401729.png","player2logobig":"http://p8.qhimg.com/t01fdabb4fd4f401729.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=22","score":"97-112","status":"2","time":"01/27 11:00"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/g/ge0z2udqzq6015s.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468179","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468179%26title%3D%25E5%25B0%258F%25E7%2589%259BVS%25E6%25B9%2596%25E4%25BA%25BA%26ptag%3D360.onebox.schedule.nba&m=254412&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468179%26title%3D%25E5%25B0%258F%25E7%2589%259BVS%25E6%25B9%2596%25E4%25BA%25BA%26ptag%3D360.onebox.schedule.nba&m=254412&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"小牛","player1logo":"http://p0.qhimg.com/t016809e551c18d1ad5.png","player1logobig":"http://p0.qhimg.com/t016809e551c18d1ad5.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=6","player2":"湖人","player2logo":"http://p1.qhimg.com/t018b634f8a252b4177.png","player2logobig":"http://p1.qhimg.com/t018b634f8a252b4177.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=13","score":"92-90","status":"2","time":"01/27 11:30"}],"live":null,"livelink":null,"bottomlink":[{"text":"常规赛赛程","url":"http://kbs.sports.qq.com/?ptag=360.onebox.schedule.nba#nba"},{"text":"球队排名","url":"http://nbadata.sports.qq.com/rank/2015teamrank.html?ptag=360.onebox.schedule.nba"},{"text":"球员排名","url":"http://nbadata.sports.qq.com/stats/player/2015playerstatsindex.html?ptag=360.onebox.schedule.nba"},{"text":"社区讨论","url":"http://sports.qq.com/fans/group.htm?mid=69"}]},{"title":"01-28 周四","tr":[{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/l/lyax0mml3vinlv2.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468180","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468180%26title%3D%25E5%25A4%25AA%25E9%2598%25B3VS%25E9%25AA%2591%25E5%25A3%25AB%26ptag%3D360.onebox.schedule.nba&m=7fa2f4&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468180%26title%3D%25E5%25A4%25AA%25E9%2598%25B3VS%25E9%25AA%2591%25E5%25A3%25AB%26ptag%3D360.onebox.schedule.nba&m=7fa2f4&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"太阳","player1logo":"http://p8.qhimg.com/t01b949ab71ba5b6da6.png","player1logobig":"http://p8.qhimg.com/t01b949ab71ba5b6da6.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=21","player2":"骑士","player2logo":"http://p0.qhimg.com/t0162a1fa2ce42538d1.png","player2logobig":"http://p0.qhimg.com/t0162a1fa2ce42538d1.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=5","score":"93-115","status":"2","time":"01/28 08:00"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/o/o3hu7ywxkvjngsj.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468181","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468181%26title%3D%25E6%258E%2598%25E9%2587%2591VS%25E5%2587%25AF%25E5%25B0%2594%25E7%2589%25B9%25E4%25BA%25BA%26ptag%3D360.onebox.schedule.nba&m=54d578&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468181%26title%3D%25E6%258E%2598%25E9%2587%2591VS%25E5%2587%25AF%25E5%25B0%2594%25E7%2589%25B9%25E4%25BA%25BA%26ptag%3D360.onebox.schedule.nba&m=54d578&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"掘金","player1logo":"http://p7.qhimg.com/t01c366fdb3044d96db.png","player1logobig":"http://p7.qhimg.com/t01c366fdb3044d96db.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=7","player2":"凯尔特人","player2logo":"http://p5.qhimg.com/t019f61e3222cd24332.png","player2logobig":"http://p5.qhimg.com/t019f61e3222cd24332.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=2","score":"103-111","status":"2","time":"01/28 08:30"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/h/hsbonh5b10534zi.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468182","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468182%26title%3D76%25E4%25BA%25BAVS%25E6%25B4%25BB%25E5%25A1%259E%26ptag%3D360.onebox.schedule.nba&m=84abb9&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468182%26title%3D76%25E4%25BA%25BAVS%25E6%25B4%25BB%25E5%25A1%259E%26ptag%3D360.onebox.schedule.nba&m=84abb9&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"76人","player1logo":"http://p8.qhimg.com/t011e23b36ad399a0d1.png","player1logobig":"http://p8.qhimg.com/t011e23b36ad399a0d1.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=20","player2":"活塞","player2logo":"http://p5.qhimg.com/t01a80ea5beeff44608.png","player2logobig":"http://p5.qhimg.com/t01a80ea5beeff44608.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=8","score":"97-110","status":"2","time":"01/28 08:30"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/w/whvxnkpacyv1td1.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468183","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468183%26title%3D%25E5%25BF%25AB%25E8%2588%25B9VS%25E8%2580%2581%25E9%25B9%25B0%26ptag%3D360.onebox.schedule.nba&m=782c29&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468183%26title%3D%25E5%25BF%25AB%25E8%2588%25B9VS%25E8%2580%2581%25E9%25B9%25B0%26ptag%3D360.onebox.schedule.nba&m=782c29&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"快船","player1logo":"http://p2.qhimg.com/t01d220267d6bb70361.png","player1logobig":"http://p2.qhimg.com/t01d220267d6bb70361.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=12","player2":"老鹰","player2logo":"http://p0.qhimg.com/t01b2a256ed064f9d96.png","player2logobig":"http://p0.qhimg.com/t01b2a256ed064f9d96.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=1","score":"85-83","status":"2","time":"01/28 09:00"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/1/1vy3w8pgg98yj2u.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468184","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468184%26title%3D%25E9%259B%25B7%25E9%259C%2586VS%25E6%25A3%25AE%25E6%259E%2597%25E7%258B%25BC%26ptag%3D360.onebox.schedule.nba&m=05b18b&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468184%26title%3D%25E9%259B%25B7%25E9%259C%2586VS%25E6%25A3%25AE%25E6%259E%2597%25E7%258B%25BC%26ptag%3D360.onebox.schedule.nba&m=05b18b&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"雷霆","player1logo":"http://p8.qhimg.com/t0198101dee56f2e9e6.png","player1logobig":"http://p8.qhimg.com/t0198101dee56f2e9e6.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=25","player2":"森林狼","player2logo":"http://p8.qhimg.com/t0101b9d3f51b24df5c.png","player2logobig":"http://p8.qhimg.com/t0101b9d3f51b24df5c.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=16","score":"126-123","status":"2","time":"01/28 09:00"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/3/34lj341hwwd42ys.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468185","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468185%26title%3D%25E7%2581%25AB%25E7%25AE%25ADVS%25E9%25A9%25AC%25E5%2588%25BA%26ptag%3D360.onebox.schedule.nba&m=68fac9&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468185%26title%3D%25E7%2581%25AB%25E7%25AE%25ADVS%25E9%25A9%25AC%25E5%2588%25BA%26ptag%3D360.onebox.schedule.nba&m=68fac9&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"火箭","player1logo":"http://p4.qhimg.com/t016e6f0cd5acb2ebe8.png","player1logobig":"http://p4.qhimg.com/t016e6f0cd5acb2ebe8.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=10","player2":"马刺","player2logo":"http://p4.qhimg.com/t01865a1ad0b0987285.png","player2logobig":"http://p4.qhimg.com/t01865a1ad0b0987285.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=24","score":"99-130","status":"2","time":"01/28 09:00"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/7/7alx5sb8fl0r3r7.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468186","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468186%26title%3D%25E9%25BB%2584%25E8%259C%2582VS%25E7%2588%25B5%25E5%25A3%25AB%26ptag%3D360.onebox.schedule.nba&m=2431fd&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468186%26title%3D%25E9%25BB%2584%25E8%259C%2582VS%25E7%2588%25B5%25E5%25A3%25AB%26ptag%3D360.onebox.schedule.nba&m=2431fd&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"黄蜂","player1logo":"http://p8.qhimg.com/t011105782c37d4f1c8.png","player1logobig":"http://p8.qhimg.com/t011105782c37d4f1c8.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=30","player2":"爵士","player2logo":"http://p9.qhimg.com/t01fd6c067295c676d3.png","player2logobig":"http://p9.qhimg.com/t01fd6c067295c676d3.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=26","score":"73-102","status":"2","time":"01/28 10:00"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/h/hktbwyo8ugnzyo8.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468187","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468187%26title%3D%25E5%25B0%258F%25E7%2589%259BVS%25E5%258B%2587%25E5%25A3%25AB%26ptag%3D360.onebox.schedule.nba&m=47630c&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468187%26title%3D%25E5%25B0%258F%25E7%2589%259BVS%25E5%258B%2587%25E5%25A3%25AB%26ptag%3D360.onebox.schedule.nba&m=47630c&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"小牛","player1logo":"http://p0.qhimg.com/t016809e551c18d1ad5.png","player1logobig":"http://p0.qhimg.com/t016809e551c18d1ad5.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=6","player2":"勇士","player2logo":"http://p0.qhimg.com/t01dae3099bd6904c43.png","player2logobig":"http://p0.qhimg.com/t01dae3099bd6904c43.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=9","score":"107-127","status":"2","time":"01/28 11:30"}],"live":[{"liveurl":"","player1":"小牛","player1info":"胜26负22西部6名","player1location":"(客)","player1logobig":"http://p0.qhimg.com/t016809e551c18d1ad5.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=6","player2":"勇士","player2info":"胜42负4西部1名","player2location":"(主)","player2logobig":"http://p0.qhimg.com/t01dae3099bd6904c43.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=9","score":"107-127","status":"2","title":"11:30开赛 比赛结束"}],"livelink":[{"text":"视频集锦","url":"http://v.qq.com/cover/h/hktbwyo8ugnzyo8.html?ptag=360.onebox.schedule.nba"},{"text":"技术统计","url":"http://sports.qq.com/nbascore/?mid=1468187"}],"bottomlink":[{"text":"常规赛赛程","url":"http://kbs.sports.qq.com/?ptag=360.onebox.schedule.nba#nba"},{"text":"球队排名","url":"http://nbadata.sports.qq.com/rank/2015teamrank.html?ptag=360.onebox.schedule.nba"},{"text":"球员排名","url":"http://nbadata.sports.qq.com/stats/player/2015playerstatsindex.html?ptag=360.onebox.schedule.nba"},{"text":"社区讨论","url":"http://sports.qq.com/fans/group.htm?mid=69"}]},{"title":"01-29 周五","tr":[{"link1text":"视频直播","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1468188","link2text":"技术统计","link2url":"","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468188%26title%3D%25E8%2580%2581%25E9%25B9%25B0VS%25E6%25AD%25A5%25E8%25A1%258C%25E8%2580%2585%26ptag%3D360.onebox.schedule.nba&m=9ef8b5&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"","player1":"老鹰","player1logo":"http://p0.qhimg.com/t01b2a256ed064f9d96.png","player1logobig":"http://p0.qhimg.com/t01b2a256ed064f9d96.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=1","player2":"步行者","player2logo":"http://p3.qhimg.com/t01a540cb8f7dae8bd7.png","player2logobig":"http://p3.qhimg.com/t01a540cb8f7dae8bd7.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=11","score":"VS","status":"0","time":"01/29 08:00"},{"link1text":"图文直播","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1468189","link2text":"技术统计","link2url":"","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468189%26title%3D%25E6%258E%2598%25E9%2587%2591VS%25E5%25A5%2587%25E6%2589%258D%26ptag%3D360.onebox.schedule.nba&m=e9a7f1&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"","player1":"掘金","player1logo":"http://p7.qhimg.com/t01c366fdb3044d96db.png","player1logobig":"http://p7.qhimg.com/t01c366fdb3044d96db.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=7","player2":"奇才","player2logo":"http://p9.qhimg.com/t0186052b1961c20365.png","player2logobig":"http://p9.qhimg.com/t0186052b1961c20365.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=27","score":"VS","status":"0","time":"01/29 08:00"},{"link1text":"视频直播","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1468190","link2text":"技术统计","link2url":"","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468190%26title%3D%25E5%25B0%25BC%25E5%2585%258B%25E6%2596%25AFVS%25E7%258C%259B%25E9%25BE%2599%26ptag%3D360.onebox.schedule.nba&m=46f4d3&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"","player1":"尼克斯","player1logo":"http://p2.qhimg.com/t01eb9fe49a7bfa9614.png","player1logobig":"http://p2.qhimg.com/t01eb9fe49a7bfa9614.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=18","player2":"猛龙","player2logo":"http://p6.qhimg.com/t017cc5b5930e09f481.png","player2logobig":"http://p6.qhimg.com/t017cc5b5930e09f481.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=28","score":"VS","status":"0","time":"01/29 09:00"},{"link1text":"图文直播","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1468191","link2text":"技术统计","link2url":"","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468191%26title%3D%25E9%259B%2584%25E9%25B9%25BFVS%25E7%2581%25B0%25E7%2586%258A%26ptag%3D360.onebox.schedule.nba&m=90a229&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"","player1":"雄鹿","player1logo":"http://p7.qhimg.com/t0159c5c7fc7989e826.png","player1logobig":"http://p7.qhimg.com/t0159c5c7fc7989e826.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=15","player2":"灰熊","player2logo":"http://p9.qhimg.com/t01c6cd06b91021cabb.png","player2logobig":"http://p9.qhimg.com/t01c6cd06b91021cabb.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=29","score":"VS","status":"0","time":"01/29 09:00"},{"link1text":"图文直播","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1468192","link2text":"技术统计","link2url":"","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468192%26title%3D%25E5%259B%25BD%25E7%258E%258BVS%25E9%25B9%2588%25E9%25B9%2595%26ptag%3D360.onebox.schedule.nba&m=b2c869&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"","player1":"国王","player1logo":"http://p2.qhimg.com/t0179411022c3587ba2.png","player1logobig":"http://p2.qhimg.com/t0179411022c3587ba2.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=23","player2":"鹈鹕","player2logo":"http://p0.qhimg.com/t010415e17c8ec18459.png","player2logobig":"http://p0.qhimg.com/t010415e17c8ec18459.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=3","score":"VS","status":"0","time":"01/29 09:00"},{"link1text":"视频直播","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1468193","link2text":"技术统计","link2url":"","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468193%26title%3D%25E5%2585%25AC%25E7%2589%259BVS%25E6%25B9%2596%25E4%25BA%25BA%26ptag%3D360.onebox.schedule.nba&m=3c1b93&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"","player1":"公牛","player1logo":"http://p7.qhimg.com/t0190ed8c80f7525b15.png","player1logobig":"http://p7.qhimg.com/t0190ed8c80f7525b15.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=4","player2":"湖人","player2logo":"http://p1.qhimg.com/t018b634f8a252b4177.png","player2logobig":"http://p1.qhimg.com/t018b634f8a252b4177.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=13","score":"VS","status":"0","time":"01/29 11:30"}],"live":null,"livelink":null,"bottomlink":[{"text":"常规赛赛程","url":"http://kbs.sports.qq.com/?ptag=360.onebox.schedule.nba#nba"},{"text":"球队排名","url":"http://nbadata.sports.qq.com/rank/2015teamrank.html?ptag=360.onebox.schedule.nba"},{"text":"球员排名","url":"http://nbadata.sports.qq.com/stats/player/2015playerstatsindex.html?ptag=360.onebox.schedule.nba"},{"text":"社区讨论","url":"http://sports.qq.com/fans/group.htm?mid=69"}]}]
     * teammatch : [{"name":"老鹰","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=1"},{"name":"凯尔特人","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=2"},{"name":"鹈鹕","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=3"},{"name":"公牛","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=4"},{"name":"骑士","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=5"},{"name":"小牛","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=6"},{"name":"掘金","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=7"},{"name":"活塞","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=8"},{"name":"勇士","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=9"},{"name":"火箭","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=10"},{"name":"步行者","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=11"},{"name":"快船","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=12"},{"name":"湖人","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=13"},{"name":"热火","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=14"},{"name":"雄鹿","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=15"},{"name":"森林狼","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=16"},{"name":"篮网","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=17"},{"name":"尼克斯","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=18"},{"name":"魔术","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=19"},{"name":"76人","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=20"},{"name":"太阳","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=21"},{"name":"开拓者","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=22"},{"name":"国王","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=23"},{"name":"马刺","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=24"},{"name":"雷霆","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=25"},{"name":"爵士","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=26"},{"name":"奇才","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=27"},{"name":"猛龙","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=28"},{"name":"灰熊","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=29"},{"name":"黄蜂","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=5312"}]
     */

    private ResultEntity result;
    /**
     * result : {"title":"NBA2015-2016赛季_常规赛视频直播_腾讯体育","statuslist":{"st0":"未开赛","st1":"直播中","st2":"已结束"},"list":[{"title":"01-27 周三","tr":[{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/e/eog3ek4qla1w56x.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468172","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468172%26title%3D%25E5%25BF%25AB%25E8%2588%25B9VS%25E6%25AD%25A5%25E8%25A1%258C%25E8%2580%2585%26ptag%3D360.onebox.schedule.nba&m=c81cb4&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468172%26title%3D%25E5%25BF%25AB%25E8%2588%25B9VS%25E6%25AD%25A5%25E8%25A1%258C%25E8%2580%2585%26ptag%3D360.onebox.schedule.nba&m=c81cb4&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"快船","player1logo":"http://p2.qhimg.com/t01d220267d6bb70361.png","player1logobig":"http://p2.qhimg.com/t01d220267d6bb70361.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=12","player2":"步行者","player2logo":"http://p3.qhimg.com/t01a540cb8f7dae8bd7.png","player2logobig":"http://p3.qhimg.com/t01a540cb8f7dae8bd7.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=11","score":"91-89","status":"2","time":"01/27 08:00"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/y/y1nh43yjact7pdi.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468173","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468173%26title%3D%25E5%25A4%25AA%25E9%2598%25B3VS76%25E4%25BA%25BA%26ptag%3D360.onebox.schedule.nba&m=341e74&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468173%26title%3D%25E5%25A4%25AA%25E9%2598%25B3VS76%25E4%25BA%25BA%26ptag%3D360.onebox.schedule.nba&m=341e74&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"太阳","player1logo":"http://p8.qhimg.com/t01b949ab71ba5b6da6.png","player1logobig":"http://p8.qhimg.com/t01b949ab71ba5b6da6.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=21","player2":"76人","player2logo":"http://p8.qhimg.com/t011e23b36ad399a0d1.png","player2logobig":"http://p8.qhimg.com/t011e23b36ad399a0d1.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=20","score":"103-113","status":"2","time":"01/27 08:00"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/b/ba2zi8qztpxrvyf.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468174","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468174%26title%3D%25E7%2583%25AD%25E7%2581%25ABVS%25E7%25AF%25AE%25E7%25BD%2591%26ptag%3D360.onebox.schedule.nba&m=990b59&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468174%26title%3D%25E7%2583%25AD%25E7%2581%25ABVS%25E7%25AF%25AE%25E7%25BD%2591%26ptag%3D360.onebox.schedule.nba&m=990b59&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"热火","player1logo":"http://p7.qhimg.com/t011bd398c0da29c27d.png","player1logobig":"http://p7.qhimg.com/t011bd398c0da29c27d.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=14","player2":"篮网","player2logo":"http://p7.qhimg.com/t01642d73a8ebb2f3b6.png","player2logobig":"http://p7.qhimg.com/t01642d73a8ebb2f3b6.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=17","score":"102-98","status":"2","time":"01/27 08:30"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/u/u3se8angql4b02v.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468175","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468175%26title%3D%25E9%259B%25B7%25E9%259C%2586VS%25E5%25B0%25BC%25E5%2585%258B%25E6%2596%25AF%26ptag%3D360.onebox.schedule.nba&m=a165b4&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468175%26title%3D%25E9%259B%25B7%25E9%259C%2586VS%25E5%25B0%25BC%25E5%2585%258B%25E6%2596%25AF%26ptag%3D360.onebox.schedule.nba&m=a165b4&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"雷霆","player1logo":"http://p8.qhimg.com/t0198101dee56f2e9e6.png","player1logobig":"http://p8.qhimg.com/t0198101dee56f2e9e6.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=25","player2":"尼克斯","player2logo":"http://p2.qhimg.com/t01eb9fe49a7bfa9614.png","player2logobig":"http://p2.qhimg.com/t01eb9fe49a7bfa9614.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=18","score":"128-122","status":"2","time":"01/27 08:30"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/3/34c7fs4urb56lu2.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468176","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468176%26title%3D%25E5%25A5%2587%25E6%2589%258DVS%25E7%258C%259B%25E9%25BE%2599%26ptag%3D360.onebox.schedule.nba&m=9821b9&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468176%26title%3D%25E5%25A5%2587%25E6%2589%258DVS%25E7%258C%259B%25E9%25BE%2599%26ptag%3D360.onebox.schedule.nba&m=9821b9&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"奇才","player1logo":"http://p9.qhimg.com/t0186052b1961c20365.png","player1logobig":"http://p9.qhimg.com/t0186052b1961c20365.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=27","player2":"猛龙","player2logo":"http://p6.qhimg.com/t017cc5b5930e09f481.png","player2logobig":"http://p6.qhimg.com/t017cc5b5930e09f481.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=28","score":"89-106","status":"2","time":"01/27 08:30"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/f/fwzmrv5dxp2qbgn.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468177","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468177%26title%3D%25E9%25AD%2594%25E6%259C%25AFVS%25E9%259B%2584%25E9%25B9%25BF%26ptag%3D360.onebox.schedule.nba&m=1fd38d&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468177%26title%3D%25E9%25AD%2594%25E6%259C%25AFVS%25E9%259B%2584%25E9%25B9%25BF%26ptag%3D360.onebox.schedule.nba&m=1fd38d&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"魔术","player1logo":"http://p6.qhimg.com/t015a91103bd3713d72.png","player1logobig":"http://p6.qhimg.com/t015a91103bd3713d72.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=19","player2":"雄鹿","player2logo":"http://p7.qhimg.com/t0159c5c7fc7989e826.png","player2logobig":"http://p7.qhimg.com/t0159c5c7fc7989e826.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=15","score":"100-107","status":"2","time":"01/27 09:00"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/x/xixqssx0jpr5sa0.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468178","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468178%26title%3D%25E5%259B%25BD%25E7%258E%258BVS%25E5%25BC%2580%25E6%258B%2593%25E8%2580%2585%26ptag%3D360.onebox.schedule.nba&m=b8303f&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468178%26title%3D%25E5%259B%25BD%25E7%258E%258BVS%25E5%25BC%2580%25E6%258B%2593%25E8%2580%2585%26ptag%3D360.onebox.schedule.nba&m=b8303f&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"国王","player1logo":"http://p2.qhimg.com/t0179411022c3587ba2.png","player1logobig":"http://p2.qhimg.com/t0179411022c3587ba2.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=23","player2":"开拓者","player2logo":"http://p8.qhimg.com/t01fdabb4fd4f401729.png","player2logobig":"http://p8.qhimg.com/t01fdabb4fd4f401729.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=22","score":"97-112","status":"2","time":"01/27 11:00"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/g/ge0z2udqzq6015s.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468179","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468179%26title%3D%25E5%25B0%258F%25E7%2589%259BVS%25E6%25B9%2596%25E4%25BA%25BA%26ptag%3D360.onebox.schedule.nba&m=254412&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468179%26title%3D%25E5%25B0%258F%25E7%2589%259BVS%25E6%25B9%2596%25E4%25BA%25BA%26ptag%3D360.onebox.schedule.nba&m=254412&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"小牛","player1logo":"http://p0.qhimg.com/t016809e551c18d1ad5.png","player1logobig":"http://p0.qhimg.com/t016809e551c18d1ad5.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=6","player2":"湖人","player2logo":"http://p1.qhimg.com/t018b634f8a252b4177.png","player2logobig":"http://p1.qhimg.com/t018b634f8a252b4177.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=13","score":"92-90","status":"2","time":"01/27 11:30"}],"live":null,"livelink":null,"bottomlink":[{"text":"常规赛赛程","url":"http://kbs.sports.qq.com/?ptag=360.onebox.schedule.nba#nba"},{"text":"球队排名","url":"http://nbadata.sports.qq.com/rank/2015teamrank.html?ptag=360.onebox.schedule.nba"},{"text":"球员排名","url":"http://nbadata.sports.qq.com/stats/player/2015playerstatsindex.html?ptag=360.onebox.schedule.nba"},{"text":"社区讨论","url":"http://sports.qq.com/fans/group.htm?mid=69"}]},{"title":"01-28 周四","tr":[{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/l/lyax0mml3vinlv2.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468180","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468180%26title%3D%25E5%25A4%25AA%25E9%2598%25B3VS%25E9%25AA%2591%25E5%25A3%25AB%26ptag%3D360.onebox.schedule.nba&m=7fa2f4&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468180%26title%3D%25E5%25A4%25AA%25E9%2598%25B3VS%25E9%25AA%2591%25E5%25A3%25AB%26ptag%3D360.onebox.schedule.nba&m=7fa2f4&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"太阳","player1logo":"http://p8.qhimg.com/t01b949ab71ba5b6da6.png","player1logobig":"http://p8.qhimg.com/t01b949ab71ba5b6da6.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=21","player2":"骑士","player2logo":"http://p0.qhimg.com/t0162a1fa2ce42538d1.png","player2logobig":"http://p0.qhimg.com/t0162a1fa2ce42538d1.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=5","score":"93-115","status":"2","time":"01/28 08:00"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/o/o3hu7ywxkvjngsj.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468181","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468181%26title%3D%25E6%258E%2598%25E9%2587%2591VS%25E5%2587%25AF%25E5%25B0%2594%25E7%2589%25B9%25E4%25BA%25BA%26ptag%3D360.onebox.schedule.nba&m=54d578&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468181%26title%3D%25E6%258E%2598%25E9%2587%2591VS%25E5%2587%25AF%25E5%25B0%2594%25E7%2589%25B9%25E4%25BA%25BA%26ptag%3D360.onebox.schedule.nba&m=54d578&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"掘金","player1logo":"http://p7.qhimg.com/t01c366fdb3044d96db.png","player1logobig":"http://p7.qhimg.com/t01c366fdb3044d96db.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=7","player2":"凯尔特人","player2logo":"http://p5.qhimg.com/t019f61e3222cd24332.png","player2logobig":"http://p5.qhimg.com/t019f61e3222cd24332.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=2","score":"103-111","status":"2","time":"01/28 08:30"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/h/hsbonh5b10534zi.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468182","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468182%26title%3D76%25E4%25BA%25BAVS%25E6%25B4%25BB%25E5%25A1%259E%26ptag%3D360.onebox.schedule.nba&m=84abb9&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468182%26title%3D76%25E4%25BA%25BAVS%25E6%25B4%25BB%25E5%25A1%259E%26ptag%3D360.onebox.schedule.nba&m=84abb9&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"76人","player1logo":"http://p8.qhimg.com/t011e23b36ad399a0d1.png","player1logobig":"http://p8.qhimg.com/t011e23b36ad399a0d1.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=20","player2":"活塞","player2logo":"http://p5.qhimg.com/t01a80ea5beeff44608.png","player2logobig":"http://p5.qhimg.com/t01a80ea5beeff44608.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=8","score":"97-110","status":"2","time":"01/28 08:30"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/w/whvxnkpacyv1td1.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468183","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468183%26title%3D%25E5%25BF%25AB%25E8%2588%25B9VS%25E8%2580%2581%25E9%25B9%25B0%26ptag%3D360.onebox.schedule.nba&m=782c29&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468183%26title%3D%25E5%25BF%25AB%25E8%2588%25B9VS%25E8%2580%2581%25E9%25B9%25B0%26ptag%3D360.onebox.schedule.nba&m=782c29&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"快船","player1logo":"http://p2.qhimg.com/t01d220267d6bb70361.png","player1logobig":"http://p2.qhimg.com/t01d220267d6bb70361.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=12","player2":"老鹰","player2logo":"http://p0.qhimg.com/t01b2a256ed064f9d96.png","player2logobig":"http://p0.qhimg.com/t01b2a256ed064f9d96.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=1","score":"85-83","status":"2","time":"01/28 09:00"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/1/1vy3w8pgg98yj2u.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468184","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468184%26title%3D%25E9%259B%25B7%25E9%259C%2586VS%25E6%25A3%25AE%25E6%259E%2597%25E7%258B%25BC%26ptag%3D360.onebox.schedule.nba&m=05b18b&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468184%26title%3D%25E9%259B%25B7%25E9%259C%2586VS%25E6%25A3%25AE%25E6%259E%2597%25E7%258B%25BC%26ptag%3D360.onebox.schedule.nba&m=05b18b&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"雷霆","player1logo":"http://p8.qhimg.com/t0198101dee56f2e9e6.png","player1logobig":"http://p8.qhimg.com/t0198101dee56f2e9e6.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=25","player2":"森林狼","player2logo":"http://p8.qhimg.com/t0101b9d3f51b24df5c.png","player2logobig":"http://p8.qhimg.com/t0101b9d3f51b24df5c.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=16","score":"126-123","status":"2","time":"01/28 09:00"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/3/34lj341hwwd42ys.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468185","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468185%26title%3D%25E7%2581%25AB%25E7%25AE%25ADVS%25E9%25A9%25AC%25E5%2588%25BA%26ptag%3D360.onebox.schedule.nba&m=68fac9&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468185%26title%3D%25E7%2581%25AB%25E7%25AE%25ADVS%25E9%25A9%25AC%25E5%2588%25BA%26ptag%3D360.onebox.schedule.nba&m=68fac9&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"火箭","player1logo":"http://p4.qhimg.com/t016e6f0cd5acb2ebe8.png","player1logobig":"http://p4.qhimg.com/t016e6f0cd5acb2ebe8.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=10","player2":"马刺","player2logo":"http://p4.qhimg.com/t01865a1ad0b0987285.png","player2logobig":"http://p4.qhimg.com/t01865a1ad0b0987285.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=24","score":"99-130","status":"2","time":"01/28 09:00"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/7/7alx5sb8fl0r3r7.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468186","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468186%26title%3D%25E9%25BB%2584%25E8%259C%2582VS%25E7%2588%25B5%25E5%25A3%25AB%26ptag%3D360.onebox.schedule.nba&m=2431fd&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468186%26title%3D%25E9%25BB%2584%25E8%259C%2582VS%25E7%2588%25B5%25E5%25A3%25AB%26ptag%3D360.onebox.schedule.nba&m=2431fd&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"黄蜂","player1logo":"http://p8.qhimg.com/t011105782c37d4f1c8.png","player1logobig":"http://p8.qhimg.com/t011105782c37d4f1c8.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=30","player2":"爵士","player2logo":"http://p9.qhimg.com/t01fd6c067295c676d3.png","player2logobig":"http://p9.qhimg.com/t01fd6c067295c676d3.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=26","score":"73-102","status":"2","time":"01/28 10:00"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/h/hktbwyo8ugnzyo8.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468187","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468187%26title%3D%25E5%25B0%258F%25E7%2589%259BVS%25E5%258B%2587%25E5%25A3%25AB%26ptag%3D360.onebox.schedule.nba&m=47630c&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468187%26title%3D%25E5%25B0%258F%25E7%2589%259BVS%25E5%258B%2587%25E5%25A3%25AB%26ptag%3D360.onebox.schedule.nba&m=47630c&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"小牛","player1logo":"http://p0.qhimg.com/t016809e551c18d1ad5.png","player1logobig":"http://p0.qhimg.com/t016809e551c18d1ad5.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=6","player2":"勇士","player2logo":"http://p0.qhimg.com/t01dae3099bd6904c43.png","player2logobig":"http://p0.qhimg.com/t01dae3099bd6904c43.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=9","score":"107-127","status":"2","time":"01/28 11:30"}],"live":[{"liveurl":"","player1":"小牛","player1info":"胜26负22西部6名","player1location":"(客)","player1logobig":"http://p0.qhimg.com/t016809e551c18d1ad5.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=6","player2":"勇士","player2info":"胜42负4西部1名","player2location":"(主)","player2logobig":"http://p0.qhimg.com/t01dae3099bd6904c43.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=9","score":"107-127","status":"2","title":"11:30开赛 比赛结束"}],"livelink":[{"text":"视频集锦","url":"http://v.qq.com/cover/h/hktbwyo8ugnzyo8.html?ptag=360.onebox.schedule.nba"},{"text":"技术统计","url":"http://sports.qq.com/nbascore/?mid=1468187"}],"bottomlink":[{"text":"常规赛赛程","url":"http://kbs.sports.qq.com/?ptag=360.onebox.schedule.nba#nba"},{"text":"球队排名","url":"http://nbadata.sports.qq.com/rank/2015teamrank.html?ptag=360.onebox.schedule.nba"},{"text":"球员排名","url":"http://nbadata.sports.qq.com/stats/player/2015playerstatsindex.html?ptag=360.onebox.schedule.nba"},{"text":"社区讨论","url":"http://sports.qq.com/fans/group.htm?mid=69"}]},{"title":"01-29 周五","tr":[{"link1text":"视频直播","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1468188","link2text":"技术统计","link2url":"","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468188%26title%3D%25E8%2580%2581%25E9%25B9%25B0VS%25E6%25AD%25A5%25E8%25A1%258C%25E8%2580%2585%26ptag%3D360.onebox.schedule.nba&m=9ef8b5&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"","player1":"老鹰","player1logo":"http://p0.qhimg.com/t01b2a256ed064f9d96.png","player1logobig":"http://p0.qhimg.com/t01b2a256ed064f9d96.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=1","player2":"步行者","player2logo":"http://p3.qhimg.com/t01a540cb8f7dae8bd7.png","player2logobig":"http://p3.qhimg.com/t01a540cb8f7dae8bd7.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=11","score":"VS","status":"0","time":"01/29 08:00"},{"link1text":"图文直播","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1468189","link2text":"技术统计","link2url":"","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468189%26title%3D%25E6%258E%2598%25E9%2587%2591VS%25E5%25A5%2587%25E6%2589%258D%26ptag%3D360.onebox.schedule.nba&m=e9a7f1&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"","player1":"掘金","player1logo":"http://p7.qhimg.com/t01c366fdb3044d96db.png","player1logobig":"http://p7.qhimg.com/t01c366fdb3044d96db.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=7","player2":"奇才","player2logo":"http://p9.qhimg.com/t0186052b1961c20365.png","player2logobig":"http://p9.qhimg.com/t0186052b1961c20365.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=27","score":"VS","status":"0","time":"01/29 08:00"},{"link1text":"视频直播","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1468190","link2text":"技术统计","link2url":"","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468190%26title%3D%25E5%25B0%25BC%25E5%2585%258B%25E6%2596%25AFVS%25E7%258C%259B%25E9%25BE%2599%26ptag%3D360.onebox.schedule.nba&m=46f4d3&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"","player1":"尼克斯","player1logo":"http://p2.qhimg.com/t01eb9fe49a7bfa9614.png","player1logobig":"http://p2.qhimg.com/t01eb9fe49a7bfa9614.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=18","player2":"猛龙","player2logo":"http://p6.qhimg.com/t017cc5b5930e09f481.png","player2logobig":"http://p6.qhimg.com/t017cc5b5930e09f481.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=28","score":"VS","status":"0","time":"01/29 09:00"},{"link1text":"图文直播","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1468191","link2text":"技术统计","link2url":"","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468191%26title%3D%25E9%259B%2584%25E9%25B9%25BFVS%25E7%2581%25B0%25E7%2586%258A%26ptag%3D360.onebox.schedule.nba&m=90a229&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"","player1":"雄鹿","player1logo":"http://p7.qhimg.com/t0159c5c7fc7989e826.png","player1logobig":"http://p7.qhimg.com/t0159c5c7fc7989e826.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=15","player2":"灰熊","player2logo":"http://p9.qhimg.com/t01c6cd06b91021cabb.png","player2logobig":"http://p9.qhimg.com/t01c6cd06b91021cabb.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=29","score":"VS","status":"0","time":"01/29 09:00"},{"link1text":"图文直播","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1468192","link2text":"技术统计","link2url":"","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468192%26title%3D%25E5%259B%25BD%25E7%258E%258BVS%25E9%25B9%2588%25E9%25B9%2595%26ptag%3D360.onebox.schedule.nba&m=b2c869&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"","player1":"国王","player1logo":"http://p2.qhimg.com/t0179411022c3587ba2.png","player1logobig":"http://p2.qhimg.com/t0179411022c3587ba2.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=23","player2":"鹈鹕","player2logo":"http://p0.qhimg.com/t010415e17c8ec18459.png","player2logobig":"http://p0.qhimg.com/t010415e17c8ec18459.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=3","score":"VS","status":"0","time":"01/29 09:00"},{"link1text":"视频直播","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1468193","link2text":"技术统计","link2url":"","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468193%26title%3D%25E5%2585%25AC%25E7%2589%259BVS%25E6%25B9%2596%25E4%25BA%25BA%26ptag%3D360.onebox.schedule.nba&m=3c1b93&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"","player1":"公牛","player1logo":"http://p7.qhimg.com/t0190ed8c80f7525b15.png","player1logobig":"http://p7.qhimg.com/t0190ed8c80f7525b15.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=4","player2":"湖人","player2logo":"http://p1.qhimg.com/t018b634f8a252b4177.png","player2logobig":"http://p1.qhimg.com/t018b634f8a252b4177.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=13","score":"VS","status":"0","time":"01/29 11:30"}],"live":null,"livelink":null,"bottomlink":[{"text":"常规赛赛程","url":"http://kbs.sports.qq.com/?ptag=360.onebox.schedule.nba#nba"},{"text":"球队排名","url":"http://nbadata.sports.qq.com/rank/2015teamrank.html?ptag=360.onebox.schedule.nba"},{"text":"球员排名","url":"http://nbadata.sports.qq.com/stats/player/2015playerstatsindex.html?ptag=360.onebox.schedule.nba"},{"text":"社区讨论","url":"http://sports.qq.com/fans/group.htm?mid=69"}]}],"teammatch":[{"name":"老鹰","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=1"},{"name":"凯尔特人","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=2"},{"name":"鹈鹕","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=3"},{"name":"公牛","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=4"},{"name":"骑士","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=5"},{"name":"小牛","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=6"},{"name":"掘金","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=7"},{"name":"活塞","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=8"},{"name":"勇士","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=9"},{"name":"火箭","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=10"},{"name":"步行者","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=11"},{"name":"快船","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=12"},{"name":"湖人","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=13"},{"name":"热火","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=14"},{"name":"雄鹿","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=15"},{"name":"森林狼","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=16"},{"name":"篮网","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=17"},{"name":"尼克斯","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=18"},{"name":"魔术","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=19"},{"name":"76人","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=20"},{"name":"太阳","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=21"},{"name":"开拓者","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=22"},{"name":"国王","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=23"},{"name":"马刺","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=24"},{"name":"雷霆","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=25"},{"name":"爵士","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=26"},{"name":"奇才","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=27"},{"name":"猛龙","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=28"},{"name":"灰熊","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=29"},{"name":"黄蜂","url":"http://nbadata.sports.qq.com/schedule/index.html?TeamID=5312"}]}
     * error_code : 0
     * reason : Succes
     */

    private int error_code;
    private String reason;

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultEntity getResult() {
        return result;
    }

    public int getError_code() {
        return error_code;
    }

    public String getReason() {
        return reason;
    }

    public static class ResultEntity {
        private String title;
        /**
         * st0 : 未开赛
         * st1 : 直播中
         * st2 : 已结束
         */

        private StatuslistEntity statuslist;
        /**
         * title : 01-27 周三
         * tr : [{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/e/eog3ek4qla1w56x.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468172","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468172%26title%3D%25E5%25BF%25AB%25E8%2588%25B9VS%25E6%25AD%25A5%25E8%25A1%258C%25E8%2580%2585%26ptag%3D360.onebox.schedule.nba&m=c81cb4&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468172%26title%3D%25E5%25BF%25AB%25E8%2588%25B9VS%25E6%25AD%25A5%25E8%25A1%258C%25E8%2580%2585%26ptag%3D360.onebox.schedule.nba&m=c81cb4&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"快船","player1logo":"http://p2.qhimg.com/t01d220267d6bb70361.png","player1logobig":"http://p2.qhimg.com/t01d220267d6bb70361.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=12","player2":"步行者","player2logo":"http://p3.qhimg.com/t01a540cb8f7dae8bd7.png","player2logobig":"http://p3.qhimg.com/t01a540cb8f7dae8bd7.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=11","score":"91-89","status":"2","time":"01/27 08:00"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/y/y1nh43yjact7pdi.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468173","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468173%26title%3D%25E5%25A4%25AA%25E9%2598%25B3VS76%25E4%25BA%25BA%26ptag%3D360.onebox.schedule.nba&m=341e74&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468173%26title%3D%25E5%25A4%25AA%25E9%2598%25B3VS76%25E4%25BA%25BA%26ptag%3D360.onebox.schedule.nba&m=341e74&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"太阳","player1logo":"http://p8.qhimg.com/t01b949ab71ba5b6da6.png","player1logobig":"http://p8.qhimg.com/t01b949ab71ba5b6da6.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=21","player2":"76人","player2logo":"http://p8.qhimg.com/t011e23b36ad399a0d1.png","player2logobig":"http://p8.qhimg.com/t011e23b36ad399a0d1.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=20","score":"103-113","status":"2","time":"01/27 08:00"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/b/ba2zi8qztpxrvyf.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468174","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468174%26title%3D%25E7%2583%25AD%25E7%2581%25ABVS%25E7%25AF%25AE%25E7%25BD%2591%26ptag%3D360.onebox.schedule.nba&m=990b59&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468174%26title%3D%25E7%2583%25AD%25E7%2581%25ABVS%25E7%25AF%25AE%25E7%25BD%2591%26ptag%3D360.onebox.schedule.nba&m=990b59&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"热火","player1logo":"http://p7.qhimg.com/t011bd398c0da29c27d.png","player1logobig":"http://p7.qhimg.com/t011bd398c0da29c27d.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=14","player2":"篮网","player2logo":"http://p7.qhimg.com/t01642d73a8ebb2f3b6.png","player2logobig":"http://p7.qhimg.com/t01642d73a8ebb2f3b6.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=17","score":"102-98","status":"2","time":"01/27 08:30"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/u/u3se8angql4b02v.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468175","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468175%26title%3D%25E9%259B%25B7%25E9%259C%2586VS%25E5%25B0%25BC%25E5%2585%258B%25E6%2596%25AF%26ptag%3D360.onebox.schedule.nba&m=a165b4&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468175%26title%3D%25E9%259B%25B7%25E9%259C%2586VS%25E5%25B0%25BC%25E5%2585%258B%25E6%2596%25AF%26ptag%3D360.onebox.schedule.nba&m=a165b4&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"雷霆","player1logo":"http://p8.qhimg.com/t0198101dee56f2e9e6.png","player1logobig":"http://p8.qhimg.com/t0198101dee56f2e9e6.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=25","player2":"尼克斯","player2logo":"http://p2.qhimg.com/t01eb9fe49a7bfa9614.png","player2logobig":"http://p2.qhimg.com/t01eb9fe49a7bfa9614.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=18","score":"128-122","status":"2","time":"01/27 08:30"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/3/34c7fs4urb56lu2.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468176","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468176%26title%3D%25E5%25A5%2587%25E6%2589%258DVS%25E7%258C%259B%25E9%25BE%2599%26ptag%3D360.onebox.schedule.nba&m=9821b9&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468176%26title%3D%25E5%25A5%2587%25E6%2589%258DVS%25E7%258C%259B%25E9%25BE%2599%26ptag%3D360.onebox.schedule.nba&m=9821b9&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"奇才","player1logo":"http://p9.qhimg.com/t0186052b1961c20365.png","player1logobig":"http://p9.qhimg.com/t0186052b1961c20365.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=27","player2":"猛龙","player2logo":"http://p6.qhimg.com/t017cc5b5930e09f481.png","player2logobig":"http://p6.qhimg.com/t017cc5b5930e09f481.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=28","score":"89-106","status":"2","time":"01/27 08:30"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/f/fwzmrv5dxp2qbgn.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468177","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468177%26title%3D%25E9%25AD%2594%25E6%259C%25AFVS%25E9%259B%2584%25E9%25B9%25BF%26ptag%3D360.onebox.schedule.nba&m=1fd38d&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468177%26title%3D%25E9%25AD%2594%25E6%259C%25AFVS%25E9%259B%2584%25E9%25B9%25BF%26ptag%3D360.onebox.schedule.nba&m=1fd38d&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"魔术","player1logo":"http://p6.qhimg.com/t015a91103bd3713d72.png","player1logobig":"http://p6.qhimg.com/t015a91103bd3713d72.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=19","player2":"雄鹿","player2logo":"http://p7.qhimg.com/t0159c5c7fc7989e826.png","player2logobig":"http://p7.qhimg.com/t0159c5c7fc7989e826.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=15","score":"100-107","status":"2","time":"01/27 09:00"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/x/xixqssx0jpr5sa0.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468178","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468178%26title%3D%25E5%259B%25BD%25E7%258E%258BVS%25E5%25BC%2580%25E6%258B%2593%25E8%2580%2585%26ptag%3D360.onebox.schedule.nba&m=b8303f&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468178%26title%3D%25E5%259B%25BD%25E7%258E%258BVS%25E5%25BC%2580%25E6%258B%2593%25E8%2580%2585%26ptag%3D360.onebox.schedule.nba&m=b8303f&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"国王","player1logo":"http://p2.qhimg.com/t0179411022c3587ba2.png","player1logobig":"http://p2.qhimg.com/t0179411022c3587ba2.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=23","player2":"开拓者","player2logo":"http://p8.qhimg.com/t01fdabb4fd4f401729.png","player2logobig":"http://p8.qhimg.com/t01fdabb4fd4f401729.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=22","score":"97-112","status":"2","time":"01/27 11:00"},{"link1text":"视频集锦","link1url":"http://v.qq.com/cover/g/ge0z2udqzq6015s.html?ptag=360.onebox.schedule.nba","link2text":"技术统计","link2url":"http://sports.qq.com/nbascore/?mid=1468179","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468179%26title%3D%25E5%25B0%258F%25E7%2589%259BVS%25E6%25B9%2596%25E4%25BA%25BA%26ptag%3D360.onebox.schedule.nba&m=254412&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468179%26title%3D%25E5%25B0%258F%25E7%2589%259BVS%25E6%25B9%2596%25E4%25BA%25BA%26ptag%3D360.onebox.schedule.nba&m=254412&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc","player1":"小牛","player1logo":"http://p0.qhimg.com/t016809e551c18d1ad5.png","player1logobig":"http://p0.qhimg.com/t016809e551c18d1ad5.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=6","player2":"湖人","player2logo":"http://p1.qhimg.com/t018b634f8a252b4177.png","player2logobig":"http://p1.qhimg.com/t018b634f8a252b4177.png","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=13","score":"92-90","status":"2","time":"01/27 11:30"}]
         * live : null
         * livelink : null
         * bottomlink : [{"text":"常规赛赛程","url":"http://kbs.sports.qq.com/?ptag=360.onebox.schedule.nba#nba"},{"text":"球队排名","url":"http://nbadata.sports.qq.com/rank/2015teamrank.html?ptag=360.onebox.schedule.nba"},{"text":"球员排名","url":"http://nbadata.sports.qq.com/stats/player/2015playerstatsindex.html?ptag=360.onebox.schedule.nba"},{"text":"社区讨论","url":"http://sports.qq.com/fans/group.htm?mid=69"}]
         */

        private List<ListEntity> list;
        /**
         * name : 老鹰
         * url : http://nbadata.sports.qq.com/schedule/index.html?TeamID=1
         */

        private List<TeammatchEntity> teammatch;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setStatuslist(StatuslistEntity statuslist) {
            this.statuslist = statuslist;
        }

        public void setList(List<ListEntity> list) {
            this.list = list;
        }

        public void setTeammatch(List<TeammatchEntity> teammatch) {
            this.teammatch = teammatch;
        }

        public String getTitle() {
            return title;
        }

        public StatuslistEntity getStatuslist() {
            return statuslist;
        }

        public List<ListEntity> getList() {
            return list;
        }

        public List<TeammatchEntity> getTeammatch() {
            return teammatch;
        }

        public static class StatuslistEntity {
            private String st0;
            private String st1;
            private String st2;

            public void setSt0(String st0) {
                this.st0 = st0;
            }

            public void setSt1(String st1) {
                this.st1 = st1;
            }

            public void setSt2(String st2) {
                this.st2 = st2;
            }

            public String getSt0() {
                return st0;
            }

            public String getSt1() {
                return st1;
            }

            public String getSt2() {
                return st2;
            }
        }

        public static class ListEntity {
            private String title;
            private Object live;
            private Object livelink;
            /**
             * link1text : 视频集锦
             * link1url : http://v.qq.com/cover/e/eog3ek4qla1w56x.html?ptag=360.onebox.schedule.nba
             * link2text : 技术统计
             * link2url : http://sports.qq.com/nbascore/?mid=1468172
             * m_link1url : http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468172%26title%3D%25E5%25BF%25AB%25E8%2588%25B9VS%25E6%25AD%25A5%25E8%25A1%258C%25E8%2580%2585%26ptag%3D360.onebox.schedule.nba&m=c81cb4&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc
             * m_link2url : http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1468172%26title%3D%25E5%25BF%25AB%25E8%2588%25B9VS%25E6%25AD%25A5%25E8%25A1%258C%25E8%2580%2585%26ptag%3D360.onebox.schedule.nba&m=c81cb4&from=juhe&type=nba_new&juid=JH9e91321f482bd801c88309a347b84e45&d=pc
             * player1 : 快船
             * player1logo : http://p2.qhimg.com/t01d220267d6bb70361.png
             * player1logobig : http://p2.qhimg.com/t01d220267d6bb70361.png
             * player1url : http://kbs.sports.qq.com/kbsweb/teams.htm?tid=12
             * player2 : 步行者
             * player2logo : http://p3.qhimg.com/t01a540cb8f7dae8bd7.png
             * player2logobig : http://p3.qhimg.com/t01a540cb8f7dae8bd7.png
             * player2url : http://kbs.sports.qq.com/kbsweb/teams.htm?tid=11
             * score : 91-89
             * status : 2
             * time : 01/27 08:00
             */

            private List<TrEntity> tr;
            /**
             * text : 常规赛赛程
             * url : http://kbs.sports.qq.com/?ptag=360.onebox.schedule.nba#nba
             */

            private List<BottomlinkEntity> bottomlink;

            public void setTitle(String title) {
                this.title = title;
            }

            public void setLive(Object live) {
                this.live = live;
            }

            public void setLivelink(Object livelink) {
                this.livelink = livelink;
            }

            public void setTr(List<TrEntity> tr) {
                this.tr = tr;
            }

            public void setBottomlink(List<BottomlinkEntity> bottomlink) {
                this.bottomlink = bottomlink;
            }

            public String getTitle() {
                return title;
            }

            public Object getLive() {
                return live;
            }

            public Object getLivelink() {
                return livelink;
            }

            public List<TrEntity> getTr() {
                return tr;
            }

            public List<BottomlinkEntity> getBottomlink() {
                return bottomlink;
            }

            public static class TrEntity {
                private String link1text;
                private String link1url;
                private String link2text;
                private String link2url;
                private String m_link1url;
                private String m_link2url;
                private String player1;
                private String player1logo;
                private String player1logobig;
                private String player1url;
                private String player2;
                private String player2logo;
                private String player2logobig;
                private String player2url;
                private String score;
                private String status;
                private String time;

                public void setLink1text(String link1text) {
                    this.link1text = link1text;
                }

                public void setLink1url(String link1url) {
                    this.link1url = link1url;
                }

                public void setLink2text(String link2text) {
                    this.link2text = link2text;
                }

                public void setLink2url(String link2url) {
                    this.link2url = link2url;
                }

                public void setM_link1url(String m_link1url) {
                    this.m_link1url = m_link1url;
                }

                public void setM_link2url(String m_link2url) {
                    this.m_link2url = m_link2url;
                }

                public void setPlayer1(String player1) {
                    this.player1 = player1;
                }

                public void setPlayer1logo(String player1logo) {
                    this.player1logo = player1logo;
                }

                public void setPlayer1logobig(String player1logobig) {
                    this.player1logobig = player1logobig;
                }

                public void setPlayer1url(String player1url) {
                    this.player1url = player1url;
                }

                public void setPlayer2(String player2) {
                    this.player2 = player2;
                }

                public void setPlayer2logo(String player2logo) {
                    this.player2logo = player2logo;
                }

                public void setPlayer2logobig(String player2logobig) {
                    this.player2logobig = player2logobig;
                }

                public void setPlayer2url(String player2url) {
                    this.player2url = player2url;
                }

                public void setScore(String score) {
                    this.score = score;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public String getLink1text() {
                    return link1text;
                }

                public String getLink1url() {
                    return link1url;
                }

                public String getLink2text() {
                    return link2text;
                }

                public String getLink2url() {
                    return link2url;
                }

                public String getM_link1url() {
                    return m_link1url;
                }

                public String getM_link2url() {
                    return m_link2url;
                }

                public String getPlayer1() {
                    return player1;
                }

                public String getPlayer1logo() {
                    return player1logo;
                }

                public String getPlayer1logobig() {
                    return player1logobig;
                }

                public String getPlayer1url() {
                    return player1url;
                }

                public String getPlayer2() {
                    return player2;
                }

                public String getPlayer2logo() {
                    return player2logo;
                }

                public String getPlayer2logobig() {
                    return player2logobig;
                }

                public String getPlayer2url() {
                    return player2url;
                }

                public String getScore() {
                    return score;
                }

                public String getStatus() {
                    return status;
                }

                public String getTime() {
                    return time;
                }
            }

            public static class BottomlinkEntity {
                private String text;
                private String url;

                public void setText(String text) {
                    this.text = text;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getText() {
                    return text;
                }

                public String getUrl() {
                    return url;
                }
            }
        }

        public static class TeammatchEntity {
            private String name;
            private String url;

            public void setName(String name) {
                this.name = name;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getName() {
                return name;
            }

            public String getUrl() {
                return url;
            }
        }
    }
}
