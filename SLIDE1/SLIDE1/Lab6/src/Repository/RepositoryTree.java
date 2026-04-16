package repository;

import Connect.DBConnect;
import Entity.Tree;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositoryTree {

    public List<Tree> getAllNodes() {
        List<Tree> nodes = new ArrayList<>();
        String sql = "SELECT node_id, node_name, parent_id, level FROM tree";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Tree t = new Tree(
                        rs.getInt("node_id"),
                        rs.getString("node_name"),
                        rs.getObject("parent_id") != null ? rs.getInt("parent_id") : null,
                        rs.getInt("level")
                );
                nodes.add(t);
            }

        } catch (Exception e) {
            System.out.println("Loi khi lay danh sach node: " + e.getMessage());
        }

        return nodes;
    }

    public void addNode(Tree node) {
        String sql = "INSERT INTO tree(node_name, parent_id, level) VALUES (?, ?, ?)";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, node.getNodeName());

            if (node.getParentId() != null) {
                stmt.setInt(2, node.getParentId());
            } else {
                stmt.setNull(2, java.sql.Types.INTEGER);
            }

            stmt.setInt(3, node.getLevel());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Them node thanh cong!");
            }

        } catch (Exception e) {
            System.out.println("Loi khi them node: " + e.getMessage());
        }
    }
}
